package ma.farm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class SidebarController {

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

    private MainWindowController mainController;

    /**
     * Set the main controller for communication
     */
    public void setMainController(MainWindowController mainController) {
        this.mainController = mainController;
    }

    /**
     * Load Dashboard page
     */
    @FXML
    private void showDashboard() {
        if (mainController != null) {
            mainController.showDashboard();
        }
    }

    /**
     * Load Chicken Bay page
     */
    @FXML
    private void showChickenBay() {
        if (mainController != null) {
            mainController.showChickenBay();
        }
    }

    /**
     * Load Eggs Bay page
     */
    @FXML
    private void showEggsBay() {
        if (mainController != null) {
            mainController.showEggsBay();
        }
    }

    /**
     * Load Storage page
     */
    @FXML
    private void showStorage() {
        if (mainController != null) {
            mainController.showStorage();
        }
    }

    /**
     * Load Tasks page
     */
    @FXML
    private void showTasks() {
        if (mainController != null) {
            mainController.showTasks();
        }
    }

    /**
     * Load Personnel page
     */
    @FXML
    private void showPersonnel() {
        if (mainController != null) {
            mainController.showPersonnel();
        }
    }

    /**
     * Handle logout - return to login page
     */
    @FXML
    private void handleLogout() {
        if (mainController != null) {
            mainController.handleLogout();
        }
    }

    /**
     * Update active button style
     * @param buttonName The name of the active button
     */
    public void setActiveButton(String buttonName) {
        // Reset all buttons to default style
        Button[] buttons = {dashboardBtn, chickenBayBtn, eggsBayBtn, storageBtn, tasksBtn, personnelBtn};

        for (Button btn : buttons) {
            if (btn != null) {
                btn.setStyle("-fx-background-color: #34495e; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
            }
        }

        // Highlight the active button
        Button activeButton = null;
        switch (buttonName) {
            case "dashboard":
                activeButton = dashboardBtn;
                break;
            case "chickenBay":
                activeButton = chickenBayBtn;
                break;
            case "eggsBay":
                activeButton = eggsBayBtn;
                break;
            case "storage":
                activeButton = storageBtn;
                break;
            case "tasks":
                activeButton = tasksBtn;
                break;
            case "personnel":
                activeButton = personnelBtn;
                break;
        }

        if (activeButton != null) {
            activeButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand;");
        }
    }
}