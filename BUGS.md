# Analyse et Correction des Bugs dans UserDAO (Mise à Jour Post-Tests)

**Date : 04 Décembre 2025**

Bonjour équipe,

Suite à l'exécution des tests JUnit fournis (`UserDAOTest`), j'ai analysé la sortie de log complète. Les tests échouent massivement en raison de bugs persistants dans `UserDAO.java` et de problèmes dans la configuration des tests (pas de nettoyage DB). Cela confirme et étend les bugs identifiés précédemment. Voici un résumé mis à jour, avec focus sur les erreurs SQLite spécifiques (colonne manquante, generated keys non supportés, contraintes UNIQUE).

Les tests couvrent ~80% des cas, mais échouent à cause de :
- **Incohérences DB** : Colonne `username` absente.
- **Limites SQLite** : Pas de support pour `RETURN_GENERATED_KEYS`.
- **Pas de teardown** : DB non nettoyée entre tests → doublons d'emails → `UNIQUE constraint failed: users.email`.
- **Méthode incomplète** : `getUserByUsername` toujours vide.

**Impact global** : 0/20 tests passent pleinement ; assertions sur create/update/count/login échouent. Couverture faible due aux exceptions SQL.

Appliquez les fixes ci-dessous, puis relancez `mvn test`. Utilisez H2 pour tests (plus compatible que SQLite).

## Bugs Identifiés (Mise à Jour)

| Bug | Description | Impact | Ligne(s) concernée(s) | Fréquence dans Log |
|-----|-------------|--------|-----------------------|--------------------|
| **1. Colonne `username` inexistante** | Requêtes SQL dans `updateUser` et `getUserByUsername` référencent `username`, mais table `users` n'a que `name`. | Erreur SQL `[SQLITE_ERROR] no such column: username`. Update incomplet ; get retourne null. | `updateUser` (~105-115), `getUserByUsername` (~45-55) | Multiple (update, getByName tests) |
| **2. `getGeneratedKeys` non supporté par SQLite** | `createUser` utilise `Statement.RETURN_GENERATED_KEYS`, mais SQLite JDBC le rejette. ID non récupéré. | `SQLFeatureNotSupportedException: not implemented`. `user.setId(0)` reste ; assertions sur ID échouent. | `createUser` (~20-35) | Tous les tests create (e.g., delete, create success) |
| **3. Doublons emails (pas de cleanup DB)** | Tous tests créent user avec même email "test@example.com" sans `@AfterEach` pour delete. | `SQLITE_CONSTRAINT_UNIQUE` sur `users.email`. Create retourne false ; count erroné (3 au lieu de 4). | Global (tous tests create) | ~15 occurrences (chaque test) |
| **4. `getUserByUsername` incomplète** | Code après `executeQuery` vide ; + utilise `username` inexistant. | Retourne toujours null ; assertion `assertNotNull` échoue. | ~45-55 | Tests getByName (Success/NotFound) |
| **5. Assertions inversées/mal adaptées** | e.g., `testCreateUser_Failure_EmailExists` : `assertFalse(failed)` mais failed est true (bon) → assertFalse(true) échoue. | Tests faux-positifs ; count attend 4 mais 3 (doublons). | `UserDAOTest` (~39-42, ~149-150, ~90-94) | Create failure, count, allUsers |
| **6. Warnings mineurs** | SLF4J sans binder ; Java restricted `System.load` (SQLite). | Logs pollués ; pas bloquant mais à fixer pour prod. | Global (init DB) | Une fois par run |
| **7. Pas de gestion `creationDate` en SELECT** | Assume `Timestamp` existe, mais si DB default manquant, null. | Potentiel NPE en constructeur User. | Tous SELECT (~ e.g., 60) | Non déclenché ici |

## Corrections Proposées (Mises à Jour)

### Fix 1: Retirer `username` et corriger `updateUser` / `getUserByUsername`
- Utilisez `name` au lieu de `username`.
- Complétez `getUserByUsername` (renommez en `getUserByName` pour cohérence).

```java
// Fix getUserByUsername → getUserByName
public User getUserByName(String name) {  // Renommé
    String sql = "SELECT * FROM users WHERE name = ?";  // Changé en 'name'
    try (PreparedStatement stmt = dbConnection.getConnection().prepareStatement(sql)) {
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getTimestamp("creationDate").toLocalDateTime()
            );
        }
    } catch (SQLException e) {
        System.err.println("Error getting user by name: " + e.getMessage());
        e.printStackTrace();
    }
    return null;
}

// Fix updateUser
public boolean updateUser(User user) {
    String sql = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";  // Retiré username=?
    try (PreparedStatement stmt = dbConnection.getConnection().prepareStatement(sql)) {
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getPassword());
        stmt.setInt(4, user.getId());
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        System.err.println("Error updating user: " + e.getMessage());
        e.printStackTrace();
    }
    return false;
}