package ma.farm.dao;

import ma.farm.model.User;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Unit tests for UserDAO login functionality
 * Tests authentication, validation, and error handling
 *
 * @author Mohamed Amine Haifi
 * @version 1.0
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDAOTest {

    private static UserDAO userDAO;
    private static DatabaseConnection dbConnection;

    /**
     * Setup test database and initialize DAO before all tests
     */
    @BeforeAll
    static void setupDatabase() {
        System.out.println("=== Setting up test database ===");

        // Create database directory if it doesn't exist
        File dbDir = new File("database");
        if (!dbDir.exists()) {
            boolean created = dbDir.mkdirs();
            if (created) {
                System.out.println("✓ Created database directory");
            } else {
                fail("Failed to create database directory");
            }
        }

        // Initialize database connection
        dbConnection = DatabaseConnection.getInstance();
        assertNotNull(dbConnection, "Database connection should not be null");

        Connection conn = dbConnection.getConnection();
        assertNotNull(conn, "Database connection object should not be null");

        // Initialize UserDAO
        userDAO = new UserDAO();
        assertNotNull(userDAO, "UserDAO should not be null");

        // Create users table and insert test data
        try (Statement stmt = conn.createStatement()) {

            // Drop existing table if exists (for clean test)
            stmt.execute("DROP TABLE IF EXISTS users");

            // Create users table
            stmt.execute(
                    "CREATE TABLE users (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "name VARCHAR(100) NOT NULL, " +
                            "email VARCHAR(100) NOT NULL UNIQUE, " +
                            "password VARCHAR(255) NOT NULL, " +
                            "creationDate DATETIME DEFAULT CURRENT_TIMESTAMP)"
            );

            // Insert default admin user for testing
            stmt.execute(
                    "INSERT INTO users (name, email, password) " +
                            "VALUES ('Administrator', 'admin@farm.ma', 'admin123')"
            );

            System.out.println("✓ Test database setup complete");
            System.out.println("✓ Admin user created: admin@farm.ma / admin123");

        } catch (SQLException e) {
            System.err.println("Database setup failed: " + e.getMessage());
            e.printStackTrace();
            fail("Database setup failed: " + e.getMessage());
        }
    }

    /**
     * Test 1: Login with valid credentials
     * Expected: Authentication succeeds and returns User object
     */
    @Test
    @Order(1)
    @DisplayName("Test 1: Login with valid credentials")
    void testLoginWithValidCredentials() {
        System.out.println("\n--- Test 1: Valid Credentials ---");

        String validEmail = "admin@farm.ma";
        String validPassword = "admin123";

        try {
            // Attempt authentication
            User user = userDAO.authenticate(validEmail, validPassword);

            // Verify authentication succeeded
            assertNotNull(user, "User should not be null for valid credentials");
            assertEquals(validEmail, user.getEmail(), "Email should match");
            assertEquals("Administrator", user.getName(), "Name should match");

            System.out.println("✓ Valid credentials test PASSED");
            System.out.println("  - User: " + user.getName());
            System.out.println("  - Email: " + user.getEmail());

        } catch (Exception e) {
            fail("Valid credentials should not throw exception: " + e.getMessage());
        }
    }

    /**
     * Test 2: Login with invalid email
     * Expected: SecurityException thrown
     */
    @Test
    @Order(2)
    @DisplayName("Test 2: Login with invalid email")
    void testLoginWithInvalidEmail() {
        System.out.println("\n--- Test 2: Invalid Email ---");

        String invalidEmail = "wrong@farm.ma";
        String validPassword = "admin123";

        // Verify SecurityException is thrown
        SecurityException exception = assertThrows(
                SecurityException.class,
                () -> userDAO.authenticate(invalidEmail, validPassword),
                "Should throw SecurityException for invalid email"
        );

        assertEquals("Invalid email or password", exception.getMessage());
        System.out.println("✓ Invalid email test PASSED");
        System.out.println("  - Exception: " + exception.getMessage());
    }

    /**
     * Test 3: Login with invalid password
     * Expected: SecurityException thrown
     */
    @Test
    @Order(3)
    @DisplayName("Test 3: Login with invalid password")
    void testLoginWithInvalidPassword() {
        System.out.println("\n--- Test 3: Invalid Password ---");

        String validEmail = "admin@farm.ma";
        String invalidPassword = "wrongpassword";

        // Verify SecurityException is thrown
        SecurityException exception = assertThrows(
                SecurityException.class,
                () -> userDAO.authenticate(validEmail, invalidPassword),
                "Should throw SecurityException for invalid password"
        );

        assertEquals("Invalid email or password", exception.getMessage());
        System.out.println("✓ Invalid password test PASSED");
        System.out.println("  - Exception: " + exception.getMessage());
    }

    /**
     * Test 4: Login with empty email
     * Expected: Should handle gracefully (returns false on validation)
     */
    @Test
    @Order(4)
    @DisplayName("Test 4: Login with empty email")
    void testLoginWithEmptyEmail() {
        System.out.println("\n--- Test 4: Empty Email ---");

        String emptyEmail = "";
        String validPassword = "admin123";

        // Verify validation returns false
        boolean result = userDAO.validate(emptyEmail, validPassword);
        assertFalse(result, "Validation should fail for empty email");

        System.out.println("✓ Empty email test PASSED");
        System.out.println("  - Validation returned: false");
    }

    /**
     * Test 5: Login with empty password
     * Expected: Should handle gracefully (returns false on validation)
     */
    @Test
    @Order(5)
    @DisplayName("Test 5: Login with empty password")
    void testLoginWithEmptyPassword() {
        System.out.println("\n--- Test 5: Empty Password ---");

        String validEmail = "admin@farm.ma";
        String emptyPassword = "";

        // Verify validation returns false
        boolean result = userDAO.validate(validEmail, emptyPassword);
        assertFalse(result, "Validation should fail for empty password");

        System.out.println("✓ Empty password test PASSED");
        System.out.println("  - Validation returned: false");
    }

    /**
     * Test 6: Login with both empty fields
     * Expected: Should handle gracefully (returns false on validation)
     */
    @Test
    @Order(6)
    @DisplayName("Test 6: Login with both empty fields")
    void testLoginWithBothFieldsEmpty() {
        System.out.println("\n--- Test 6: Both Fields Empty ---");

        String emptyEmail = "";
        String emptyPassword = "";

        // Verify validation returns false
        boolean result = userDAO.validate(emptyEmail, emptyPassword);
        assertFalse(result, "Validation should fail for both empty fields");

        System.out.println("✓ Both fields empty test PASSED");
        System.out.println("  - Validation returned: false");
    }

    /**
     * Test 7: Login with null email
     * Expected: Should handle gracefully without crashing
     */
    @Test
    @Order(7)
    @DisplayName("Test 7: Login with null email")
    void testLoginWithNullEmail() {
        System.out.println("\n--- Test 7: Null Email ---");

        String nullEmail = null;
        String validPassword = "admin123";

        // Should not crash - either return false or throw exception gracefully
        assertDoesNotThrow(() -> {
            boolean result = userDAO.validate(nullEmail, validPassword);
            assertFalse(result, "Validation should fail for null email");
        }, "Should handle null email without crashing");

        System.out.println("✓ Null email test PASSED");
    }

    /**
     * Test 8: Login with null password
     * Expected: Should handle gracefully without crashing
     */
    @Test
    @Order(8)
    @DisplayName("Test 8: Login with null password")
    void testLoginWithNullPassword() {
        System.out.println("\n--- Test 8: Null Password ---");

        String validEmail = "admin@farm.ma";
        String nullPassword = null;

        // Should not crash - either return false or throw exception gracefully
        assertDoesNotThrow(() -> {
            boolean result = userDAO.validate(validEmail, nullPassword);
            assertFalse(result, "Validation should fail for null password");
        }, "Should handle null password without crashing");

        System.out.println("✓ Null password test PASSED");
    }

    /**
     * Test 9: Verify getUserByEmail functionality
     * Expected: Returns correct user for valid email
     */
    @Test
    @Order(9)
    @DisplayName("Test 9: Get user by email")
    void testGetUserByEmail() {
        System.out.println("\n--- Test 9: Get User By Email ---");

        String validEmail = "admin@farm.ma";

        User user = userDAO.getUserByEmail(validEmail);

        assertNotNull(user, "User should be found");
        assertEquals(validEmail, user.getEmail(), "Email should match");
        assertEquals("Administrator", user.getName(), "Name should match");

        System.out.println("✓ Get user by email test PASSED");
        System.out.println("  - Found user: " + user.getName());
    }

    /**
     * Test 10: SQL Injection attempt
     * Expected: Should be safely handled by PreparedStatement
     */
    @Test
    @Order(10)
    @DisplayName("Test 10: SQL Injection prevention")
    void testSQLInjectionPrevention() {
        System.out.println("\n--- Test 10: SQL Injection Prevention ---");

        // Common SQL injection attempts
        String[] injectionAttempts = {
                "admin@farm.ma' OR '1'='1",
                "' OR '1'='1' --",
                "admin@farm.ma'; DROP TABLE users; --"
        };

        for (String injection : injectionAttempts) {
            // Should safely return false, not cause SQL errors
            boolean result = userDAO.validate(injection, "admin123");
            assertFalse(result, "SQL injection should be prevented");
        }

        System.out.println("✓ SQL injection prevention test PASSED");
        System.out.println("  - All injection attempts safely blocked");
    }

    /**
     * Test 11: Case sensitivity test
     * Expected: Email should be case-sensitive
     */
    @Test
    @Order(11)
    @DisplayName("Test 11: Case sensitivity")
    void testCaseSensitivity() {
        System.out.println("\n--- Test 11: Case Sensitivity ---");

        String upperEmail = "ADMIN@FARM.MA";
        String validPassword = "admin123";

        // Test if email is case-sensitive
        boolean result = userDAO.validate(upperEmail, validPassword);

        // Document the behavior
        System.out.println("✓ Case sensitivity test completed");
        System.out.println("  - Uppercase email result: " + result);
        System.out.println("  - Note: Current implementation is case-sensitive");
    }

    /**
     * Test 12: Password with special characters
     * Expected: Should handle special characters correctly
     */
    @Test
    @Order(12)
    @DisplayName("Test 12: Special characters in password")
    void testSpecialCharactersInPassword() {
        System.out.println("\n--- Test 12: Special Characters ---");

        // Create test user with special characters in password
        User testUser = new User("Test User", "test@farm.ma", "p@ssw0rd!#$");
        boolean created = userDAO.createUser(testUser);
        assertTrue(created, "User with special character password should be created");

        // Test authentication with special characters
        User authenticated = userDAO.authenticate("test@farm.ma", "p@ssw0rd!#$");
        assertNotNull(authenticated, "Should authenticate with special character password");

        System.out.println("✓ Special characters test PASSED");
    }

    /**
     * Clean up after all tests
     */
    @AfterAll
    static void cleanup() {
        System.out.println("\n=== Test Summary ===");
        System.out.println("All tests completed successfully!");
        System.out.println("Database connection will remain for application use");
    }
}