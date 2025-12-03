package ma.farm.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private Connection connection;
    
    // Database credentials
    private static final String URL = "jdbc:sqlite:database/farm.db";
    // private static final String USERNAME = "root";
    // private static final String PASSWORD = "password";
    private static final String DRIVER = "com.sqlite.jdbc.Driver";
    
    // Private constructor for singleton
    private DatabaseConnection() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL/*, USERNAME, PASSWORD*/);
            System.out.println("Database connected successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed!");
            e.printStackTrace();
        }
    }
    
    // Get singleton instance
    public static DatabaseConnection getInstance() {
        DatabaseConnection result = DatabaseConnection.instance;
        if (result == null) {
            synchronized (DatabaseConnection.class) {
                result = DatabaseConnection.instance;
                if (result == null) {
                    DatabaseConnection.instance = result = new DatabaseConnection();
                }
            }
        }
        return result;
    }
    
    // Get connection
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL/*, USERNAME, PASSWORD*/);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    // Close connection
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}