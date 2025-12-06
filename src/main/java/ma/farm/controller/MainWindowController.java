package ma.farm.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {

    @FXML
    private BorderPane mainContainer;

    @FXML
    private AnchorPane contentArea;

    @FXML
    private SidebarController sidebarController; // Injected automatically by fx:include

    /**
     * Initialize method - called automatically after FXML is loaded
     */
    @FXML
    public void initialize() {
        // Set main controller reference in sidebar
        if (sidebarController != null) {
            sidebarController.setMainController(this);
        }

        // Load Dashboard by default
        showDashboard();
    }

    /**
     * Load Dashboard page
     */
    public void showDashboard() {
        loadPage("/fxml/DashboardView.fxml");
        if (sidebarController != null) {
            sidebarController.setActiveButton("dashboard");
        }
    }

    /**
     * Load Chicken Bay page
     */
    public void showChickenBay() {
        loadPage("/fxml/ChickenBayView.fxml");
        if (sidebarController != null) {
            sidebarController.setActiveButton("chickenBay");
        }
    }

    /**
     * Load Eggs Bay page
     */
    public void showEggsBay() {
        loadPage("/fxml/EggsBayView.fxml");
        if (sidebarController != null) {
            sidebarController.setActiveButton("eggsBay");
        }
    }

    /**
     * Load Storage page
     */
    public void showStorage() {
        loadPage("/fxml/StorageView.fxml");
        if (sidebarController != null) {
            sidebarController.setActiveButton("storage");
        }
    }

    /**
     * Load Tasks page
     */
    public void showTasks() {
        loadPage("/fxml/TasksView.fxml");
        if (sidebarController != null) {
            sidebarController.setActiveButton("tasks");
        }
    }

    /**
     * Load Personnel page
     */
    public void showPersonnel() {
        loadPage("/fxml/PersonnelView.fxml");
        if (sidebarController != null) {
            sidebarController.setActiveButton("personnel");
        }
    }

    /**
     * Handle logout - return to login page
     */
    public void handleLogout() {
        try {
            // Load login page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginView.fxml"));
            Parent loginRoot = loader.load();

            // Get current stage
            Stage stage = (Stage) mainContainer.getScene().getWindow();

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
}