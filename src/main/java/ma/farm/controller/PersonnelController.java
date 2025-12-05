package ma.farm.controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import ma.farm.dao.PersonnelDAO;
import ma.farm.model.Personnel;

import java.util.List;

/**
 * PersonnelController - Controls the Personnel view
 * Shows: Grid of personnel cards with basic info
 */
public class PersonnelController {

    // FXML Components
    @FXML
    private GridPane personnelGrid;

    @FXML
    private Label totalWorkersLabel;

    @FXML
    private Label totalTrackersLabel;

    // DAO
    private PersonnelDAO personnelDAO;

    /**
     * Initialize method - called automatically after FXML loads
     */
    @FXML
    public void initialize() {
        // TODO: Initialize DAO

        // TODO: Load personnel data

        // TODO: Populate grid with personnel cards

        // TODO: Update statistics
    }

    /**
     * Load and display all personnel
     */
    private void loadPersonnelData() {
        // TODO: Get all personnel from PersonnelDAO

        // TODO: Clear grid

        // TODO: Create card for each personnel

        // TODO: Add cards to grid (2-3 columns)

        // TODO: Update statistics
    }

    /**
     * Create a personnel card
     * @param personnel Personnel to display
     * @return VBox card containing personnel info
     */
    private VBox createPersonnelCard(Personnel personnel) {
        // TODO: Create VBox card container

        // TODO: Set card styling (border, padding, background)

        // TODO: Add name label (bold, larger font)

        // TODO: Add age label

        // TODO: Add phone label

        // TODO: Add email label

        // TODO: Add job title label (with badge)

        // TODO: Apply job title badge color:
        // - Blue for Tracker
        // - Gray for Worker

        // TODO: Return card

        return null;
    }

    /**
     * Update personnel statistics
     */
    private void updateStatistics() {
        // TODO: Count total workers (job title = "Worker")

        // TODO: Count total trackers (job title = "Tracker")

        // TODO: Update totalWorkersLabel

        // TODO: Update totalTrackersLabel
    }

    /**
     * Handle add personnel button click
     * Opens dialog to add new worker/tracker
     */
    @FXML
    public void handleAddPersonnel() {
        // TODO: Open add personnel dialog

        // TODO: Get personnel details:
        // - Full name
        // - Age
        // - Phone
        // - Email
        // - Job title (Worker or Tracker)

        // TODO: Validate inputs

        // TODO: Create Personnel record

        // TODO: Save to database

        // TODO: Refresh personnel grid
    }

    /**
     * Handle edit personnel button click
     * Opens dialog to edit selected personnel
     */
    @FXML
    public void handleEditPersonnel() {
        // TODO: Get selected personnel
        // Note: Need to track selected card somehow

        // TODO: If nothing selected, show error

        // TODO: Open edit personnel dialog with current data

        // TODO: Get updated personnel details

        // TODO: Validate inputs

        // TODO: Update Personnel record

        // TODO: Save to database

        // TODO: Refresh personnel grid
    }

    /**
     * Handle delete personnel button click
     * Deletes selected personnel
     */
    @FXML
    public void handleDeletePersonnel() {
        // TODO: Get selected personnel

        // TODO: If nothing selected, show error

        // TODO: Show confirmation dialog

        // TODO: If confirmed, delete from database

        // TODO: Refresh personnel grid
    }

    /**
     * Handle view personnel details button click
     * Shows detailed information about selected personnel
     */
    @FXML
    public void handleViewDetails() {
        // TODO: Get selected personnel

        // TODO: If nothing selected, show error

        // TODO: Open details dialog showing:
        // - All basic info
        // - Hire date
        // - Years of service
        // - Assigned tasks history
        // - Performance metrics (future)
    }

    /**
     * Handle filter by job title
     * @param jobTitle Job title to filter by (All, Worker, Tracker)
     */
    @FXML
    public void handleFilterByJobTitle(String jobTitle) {
        // TODO: Get personnel from DAO based on filter

        // TODO: Recreate grid with filtered personnel
    }

    /**
     * Apply job title badge styling
     * @param label Label to style
     * @param jobTitle Job title (Worker or Tracker)
     */
    private void applyJobTitleBadge(Label label, String jobTitle) {
        // TODO: Remove previous style classes

        // TODO: Apply color based on job title:
        // - Blue background for Tracker
        // - Gray background for Worker

        // TODO: Set text color to white

        // TODO: Add padding and border radius
    }

    /**
     * Refresh personnel grid
     */
    @FXML
    public void refreshData() {
        // TODO: Reload personnel data

        // TODO: Recreate grid

        // TODO: Update statistics
    }
}