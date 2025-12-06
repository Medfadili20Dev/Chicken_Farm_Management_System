package ma.farm.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * House model - Represents a chicken house/bay
 * Used in: Dashboard, Chicken Bay, Eggs Bay pages
 */
public class House {

    // Fields
    private int id;
    private String name;                    // H1, H2, H3, H4
    private String type;                    // Day-old, Egg Layer, Meat Female, Meat Male
    private int chickenCount;               // Current number of chickens
    private int capacity;                   // Maximum capacity
    private String healthStatus;            // Good, Fair, Poor
    private LocalDate lastCleaningDate;
    private LocalDate creationDate;

    // Default constructor
    public House() {
    }

    // Constructor without id (for creating new houses)
    public House(String name, String type, int capacity) {
    }

    // Full constructor
    public House(int id, String name, String type, int chickenCount, int capacity,
                 String healthStatus, LocalDate lastCleaningDate, LocalDate creationDate) {
    }

    // Getters and Setters
    public int getId() {
        return 0;
    }

    public void setId(int id) {
    }

    public String getName() {
        return null;
    }

    public void setName(String name) {
    }

    public String getType() {
        return null;
    }

    public void setType(String type) {
    }

    public int getChickenCount() {
        return 0;
    }

    public void setChickenCount(int chickenCount) {
    }

    public int getCapacity() {
        return 0;
    }

    public void setCapacity(int capacity) {
    }

    public String getHealthStatus() {
        return null;
    }

    public void setHealthStatus(String healthStatus) {
    }

    public LocalDate getLastCleaningDate() {
        return null;
    }

    public void setLastCleaningDate(LocalDate lastCleaningDate) {
    }

    public LocalDate getCreationDate() {
        return null;
    }

    public void setCreationDate(LocalDate creationDate) {
    }

    // Business methods

    /**
     * Calculate occupancy percentage
     * @return Percentage of house capacity used
     */
    public double getOccupancyRate() {
        return 0.0;
    }

    /**
     * Check if house is at or over capacity
     * @return true if full or overcrowded
     */
    public boolean isFull() {
        return false;
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