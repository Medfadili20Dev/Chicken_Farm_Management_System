package ma.farm.dao;

import ma.farm.model.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDAOTest {

    private static UserDAO userDAO;
    private static int testUserId;

    @BeforeAll
    static void setup() {
        userDAO = new UserDAO();
    }

    @Test
    @Order(1)
    void testCreateUser() {
        User u = new User();
        u.setName("Test User");
        u.setEmail( "user" + System.currentTimeMillis() + "@example.com");
        u.setPassword("12345");

        boolean result = userDAO.createUser(u);

        assertTrue(result, "User should be created successfully");
        assertTrue(u.getId() > 0, "User ID should be generated");

        testUserId = u.getId();
    }

    @Test
    @Order(2)
    void testValidateSuccess() {
        boolean valid = userDAO.validate("testuser@example.com", "12345");
        assertTrue(valid, "Login should be valid with correct credentials");
    }

    @Test
    @Order(3)
    void testValidateWrongPassword() {
        boolean valid = userDAO.validate("testuser@example.com", "wrongpass");
        assertFalse(valid, "Login should fail with incorrect password");
    }

    @Test
    @Order(4)
    void testAuthenticateSuccess() {
        User user = userDAO.authenticate("testuser@example.com", "12345");
        assertNotNull(user, "Authenticate should return a User");
        assertEquals("testuser@example.com", user.getEmail());
    }

    @Test
    @Order(5)
    void testAuthenticateFail() {
        assertThrows(SecurityException.class,
                () -> userDAO.authenticate("testuser@example.com", "badpass"),
                "Should throw SecurityException on invalid login"
        );
    }

    @Test
    @Order(6)
    void testLoginMethod() {
        // Vérifie que la méthode ne plante pas
        assertDoesNotThrow(() -> userDAO.login("testuser@example.com", "12345"));
    }

    @Test
    @Order(7)
    void testDeleteUser() {
        boolean deleted = userDAO.deleteUser(testUserId);
        assertTrue(deleted, "User should be deleted successfully");

        // Vérifier qu'il n'existe plus
        assertNull(userDAO.getUserById(testUserId));
    }
}
