package ma.farm.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ma.farm.dao.TaskDAO;
import ma.farm.model.Task;
import ma.farm.util.DateUtil;

/**
 * TasksController - Controls the Tasks view
 * Shows: List of tasks with status badges
 */
public class TasksController {

    // FXML Components
    @FXML
    private ListView<Task> tasksListView;

    @FXML
    private Label totalTasksLabel;

    @FXML
    private Label doneTasksLabel;

    @FXML
    private Label pendingTasksLabel;

    @FXML
    private Label missedTasksLabel;

    // DAO
    private TaskDAO taskDAO;

    // Observable list for UI
    private ObservableList<Task> tasksList;

    /**
     * Initialize method - called automatically after FXML loads
     */
    @FXML
    public void initialize() {
        // TODO: Initialize DAO

        // TODO: Initialize observable list

        // TODO: Setup custom cell factory for task items

        // TODO: Load tasks

        // TODO: Update task statistics
    }

    /**
     * Setup custom cell factory for task list items
     * Creates custom UI for each task with badge, description, etc.
     */
    private void setupTaskCellFactory() {
        // TODO: Create custom ListCell

        // TODO: Design task item layout:
        // - Status badge (colored label)
        // - Task description
        // - Cracked eggs count (if applicable)
        // - Assigned worker name
        // - Due date

        // TODO: Apply to tasksListView
    }

    /**
     * Load and display all tasks
     */
    private void loadTasks() {
        // TODO: Get all tasks from TaskDAO

        // TODO: Sort by status (Missed, Pending, Done)

        // TODO: Add to tasksList

        // TODO: Update tasksListView
    }

    /**
     * Update task statistics summary
     */
    private void updateTaskStatistics() {
        // TODO: Count total tasks

        // TODO: Count done tasks

        // TODO: Count pending tasks

        // TODO: Count missed tasks

        // TODO: Update labels
    }

    /**
     * Handle add task button click
     * Opens dialog to create new task
     */
    @FXML
    public void handleAddTask() {
        // TODO: Open add task dialog

        // TODO: Get task details:
        // - Description
        // - Due date
        // - Assigned worker
        // - Category (Cleaning, Feeding, Collection, Medical)
        // - House (optional)

        // TODO: Create Task record

        // TODO: Set status to "Pending"

        // TODO: Save to database

        // TODO: Refresh tasks list
    }

    /**
     * Handle mark as done button click
     * Marks selected task as completed
     */
    @FXML
    public void handleMarkAsDone() {
        // TODO: Get selected task from list

        // TODO: If nothing selected, show error

        // TODO: If already done, show message

        // TODO: Update task status to "Done"

        // TODO: Set completedAt timestamp

        // TODO: Save to database

        // TODO: Refresh tasks list
    }

    /**
     * Handle edit task button click
     * Opens dialog to edit existing task
     */
    @FXML
    public void handleEditTask() {
        // TODO: Get selected task from list

        // TODO: If nothing selected, show error

        // TODO: Open edit task dialog with current data

        // TODO: Get updated task details

        // TODO: Update Task record

        // TODO: Save to database

        // TODO: Refresh tasks list
    }

    /**
     * Handle delete task button click
     * Deletes selected task
     */
    @FXML
    public void handleDeleteTask() {
        // TODO: Get selected task from list

        // TODO: If nothing selected, show error

        // TODO: Show confirmation dialog

        // TODO: If confirmed, delete from database

        // TODO: Refresh tasks list
    }

    /**
     * Handle filter tasks by status
     * @param status Status to filter by (All, Done, Pending, Missed)
     */
    @FXML
    public void handleFilterByStatus(String status) {
        // TODO: Get tasks from DAO based on filter

        // TODO: Update tasksListView
    }

    /**
     * Create custom task cell with status badge
     * @param task The task to display
     * @return Custom cell content
     */
    private HBox createTaskCell(Task task) {
        // TODO: Create HBox container

        // TODO: Create status badge label

        // TODO: Apply badge color based on status:
        // - Green for Done
        // - Yellow for Pending
        // - Red for Missed

        // TODO: Create task description label

        // TODO: Create worker name label

        // TODO: Create due date label

        // TODO: If egg collection task, show cracked eggs

        // TODO: Arrange in HBox and return

        return null;
    }

    /**
     * Refresh tasks list
     */
    @FXML
    public void refreshData() {
        // TODO: Reload tasks

        // TODO: Update statistics
    }
}