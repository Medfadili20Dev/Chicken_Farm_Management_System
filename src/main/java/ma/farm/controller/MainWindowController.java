package ma.farm.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {

    @FXML
    private AnchorPane contentArea;

    @FXML
    private Button dashboardBtn;

    @FXML
    private Button chickenBayBtn;

    @FXML
    private Button eggsBayBtn;

    @FXML
    private Button storageBtn;

    @FXML
    private Button tasksBtn;

    @FXML
    private Button personnelBtn;

    /**
     * Initialize method - called automatically after FXML is loaded
     */
    @FXML
    public void initialize() {
        // Load Dashboard by default
        showDashboard();
    }

    /**
     * Load Dashboard page
     */
    @FXML
    private void showDashboard() {
        loadPage("/fxml/DashboardView.fxml");
        setActiveButton(dashboardBtn);
    }

    /**
     * Load Chicken Bay page
     */
    @FXML
    private void showChickenBay() {
        loadPage("/fxml/ChickenBayView.fxml");
        setActiveButton(chickenBayBtn);
    }

    /**
     * Load Eggs Bay page
     */
    @FXML
    private void showEggsBay() {
        loadPage("/fxml/EggsBayView.fxml");
        setActiveButton(eggsBayBtn);
    }

    /**
     * Load Storage page
     */
    @FXML
    private void showStorage() {
        loadPage("/fxml/StorageView.fxml");
        setActiveButton(storageBtn);
    }

    /**
     * Load Tasks page
     */
    @FXML
    private void showTasks() {
        loadPage("/fxml/TasksView.fxml");
        setActiveButton(tasksBtn);
    }

    /**
     * Load Personnel page
     */
    @FXML
    private void showPersonnel() {
        loadPage("/fxml/PersonnelView.fxml");
        setActiveButton(personnelBtn);
    }

    /**
     * Handle logout - return to login page
     */
    @FXML
    private void handleLogout() {
        try {
            // Load login page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginView.fxml"));
            Parent loginRoot = loader.load();

            // Get current stage
            Stage stage = (Stage) contentArea.getScene().getWindow();

            // Set login scene
            Scene loginScene = new Scene(loginRoot);
            stage.setScene(loginScene);
            stage.setTitle("Chicken Farm Management - Login");

            System.out.println("Logged out successfully!");

        } catch (IOException e) {
            System.err.println("Error loading login page: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Load a page into the content area
     * @param fxmlPath Path to the FXML file
     */
    private void loadPage(String fxmlPath) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent page = loader.load();

            // Clear current content
            contentArea.getChildren().clear();

            // Add new content
            contentArea.getChildren().add(page);

            // Make it fill the entire area
            AnchorPane.setTopAnchor(page, 0.0);
            AnchorPane.setBottomAnchor(page, 0.0);
            AnchorPane.setLeftAnchor(page, 0.0);
            AnchorPane.setRightAnchor(page, 0.0);

            System.out.println("Loaded page: " + fxmlPath);

        } catch (IOException e) {
            System.err.println("Error loading page: " + fxmlPath);
            e.printStackTrace();
        }
    }

    /**
     * Set the active button style (highlight the current page)
     * @param activeButton The button to highlight
     */
    private void setActiveButton(Button activeButton) {
        // Reset all buttons to default style
        dashboardBtn.setStyle("-fx-background-color: #34495e; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
        chickenBayBtn.setStyle("-fx-background-color: #34495e; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
        eggsBayBtn.setStyle("-fx-background-color: #34495e; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
        storageBtn.setStyle("-fx-background-color: #34495e; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
        tasksBtn.setStyle("-fx-background-color: #34495e; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
        personnelBtn.setStyle("-fx-background-color: #34495e; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");

        // Highlight the active button
        activeButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
    }
}