package ma.farm.dao;

import ma.farm.model.User;
import org.junit.jupiter.api.*;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {

    private static UserDAO userDAO;

    @BeforeAll
    static void setupDatabase() throws Exception {

        // Delete old DB to start clean
        File dbFile = new File("database/farm.db");
        if (dbFile.exists()) dbFile.delete();

        // Force DB creation
        DatabaseConnection.getInstance();

        // Create table + insert default admin
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute("""
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name VARCHAR(100) NOT NULL,
                    email VARCHAR(100) NOT NULL UNIQUE,
                    password VARCHAR(255) NOT NULL,
                    CreationDate DATETIME DEFAULT CURRENT_TIMESTAMP
                );
                """);

            stmt.execute("""
                INSERT OR IGNORE INTO users (name, email, password)
                VALUES ('Administrator', 'admin@farm.ma', 'admin123');
                """);
        }

        userDAO = new UserDAO();
    }

    @Test
    @Order(1)
    void testDefaultAdminExists() {
        User admin = userDAO.getUserByEmail("admin@farm.ma");

        assertNotNull(admin);
        assertEquals("Administrator", admin.getName());
    }

    @Test
    @Order(2)
    void testCreateUser() {
        User user = new User();
        user.setName("Amine");
        user.setEmail("amine@test.com");
        user.setPassword("1234");

        boolean created = userDAO.createUser(user);

        assertTrue(created);
        assertTrue(user.getId() > 0);
    }

    @Test
    @Order(3)
    void testGetUserById() {
        User user = userDAO.getUserByEmail("amine@test.com");
        assertNotNull(user);

        User fetched = userDAO.getUserById(user.getId());
        assertNotNull(fetched);
        assertEquals("Amine", fetched.getName());
    }

    @Test
    @Order(4)
    void testGetUserByEmail() {
        User user = userDAO.getUserByEmail("amine@test.com");

        assertNotNull(user);
        assertEquals("Amine", user.getName());
    }

    @Test
    @Order(5)
    void testValidate() {
        assertTrue(userDAO.validate("amine@test.com", "1234"));
        assertFalse(userDAO.validate("amine@test.com", "wrong"));
    }

    @Test
    @Order(6)
    void testAuthenticateSuccess() {
        User user = userDAO.authenticate("amine@test.com", "1234");

        assertNotNull(user);
        assertEquals("Amine", user.getName());
    }

    @Test
    @Order(7)
    void testAuthenticateFail() {
        assertThrows(SecurityException.class,
                () -> userDAO.authenticate("amine@test.com", "wrong"));
    }

    @Test
    @Order(8)
    void testUpdateUser() {
        User user = userDAO.getUserByEmail("amine@test.com");
        assertNotNull(user);

        user.setName("Amine Updated");
        boolean updated = userDAO.updateUser(user);

        assertTrue(updated);

        User updatedUser = userDAO.getUserByEmail("amine@test.com");
        assertEquals("Amine Updated", updatedUser.getName());
    }

    @Test
    @Order(9)
    void testUserCount() {
        int count = userDAO.getUserCount();

        // We expect 2 users: admin + amine
        assertEquals(2, count);
    }

    @Test
    @Order(10)
    void testDeleteUser() {
        User user = userDAO.getUserByEmail("amine@test.com");
        assertNotNull(user);

        boolean deleted = userDAO.deleteUser(user.getId());
        assertTrue(deleted);

        User mustBeNull = userDAO.getUserByEmail("amine@test.com");
        assertNull(mustBeNull);
    }
}
