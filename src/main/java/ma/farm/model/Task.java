package ma.farm.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Task model - Represents daily tasks for workers
 * Used in: Tasks page
 */
public class Task {

    // Fields
    private int id;
    private String description;             // Task description
    private String status;                  // Done, Pending, Missed
    private LocalDate dueDate;              // When task should be completed
    private LocalDateTime completedAt;      // When task was actually completed
    private String assignedTo;              // Worker name/id
    private int houseId;                    // Related house (optional)
    private String category;                // Cleaning, Feeding, Collection, Medical
    private int crackedEggs;                // For egg collection tasks
    private String notes;                   // Additional details
    private String priority;                // High, Medium, Low

    // Default constructor
    public Task() {
    }

    // Constructor for new task
    public Task(String description, LocalDate dueDate, String assignedTo, String category) {
    }

    // Full constructor
    public Task(int id, String description, String status, LocalDate dueDate,
                LocalDateTime completedAt, String assignedTo, int houseId, String category,
                int crackedEggs, String notes, String priority) {
    }

    // Getters and Setters
    public int getId() {
        return 0;
    }

    public void setId(int id) {
    }

    public String getDescription() {
        return null;
    }

    public void setDescription(String description) {
    }

    public String getStatus() {
        return null;
    }

    public void setStatus(String status) {
    }

    public LocalDate getDueDate() {
        return null;
    }

    public void setDueDate(LocalDate dueDate) {
    }

    public LocalDateTime getCompletedAt() {
        return null;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
    }

    public String getAssignedTo() {
        return null;
    }

    public void setAssignedTo(String assignedTo) {
    }

    public int getHouseId() {
        return 0;
    }

    public void setHouseId(int houseId) {
    }

    public String getCategory() {
        return null;
    }

    public void setCategory(String category) {
    }

    public int getCrackedEggs() {
        return 0;
    }

    public void setCrackedEggs(int crackedEggs) {
    }

    public String getNotes() {
        return null;
    }

    public void setNotes(String notes) {
    }

    public String getPriority() {
        return null;
    }

    public void setPriority(String priority) {
    }

    // Business methods

    /**
     * Check if task is overdue
     * @return true if past due date and not completed
     */
    public boolean isOverdue() {
        return false;
    }

    /**
     * Check if task is completed
     * @return true if status is "Done"
     */
    public boolean isCompleted() {
        return false;
    }

    /**
     * Mark task as done
     */
    public void markAsComplete() {
    }

    /**
     * Get status badge color for UI
     * @return CSS color class name
     */
    public String getStatusColor() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}