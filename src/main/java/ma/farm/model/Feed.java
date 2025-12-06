package ma.farm.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Feed model - Represents feed inventory
 * Used in: Storage page
 */
public class Feed {

    // Fields
    private int id;
    private String name;                    // Feed name
    private String type;                    // Day-old, Layer, Meat Growth
    private double quantityKg;              // Current stock in kg
    private double pricePerKg;              // Cost per kg
    private String supplier;                // Supplier name
    private LocalDate lastRestockDate;      // Last restock date
    private LocalDate expiryDate;           // Expiration date
    private double minStockLevel;           // Reorder threshold

    // Default constructor
    public Feed() {
    }

    // Constructor for new feed entry
    public Feed(String name, String type, double quantityKg, double pricePerKg) {
    }

    // Full constructor
    public Feed(int id, String name, String type, double quantityKg, double pricePerKg,
                String supplier, LocalDate lastRestockDate, LocalDate expiryDate,
                double minStockLevel) {
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

    public double getQuantityKg() {
        return 0.0;
    }

    public void setQuantityKg(double quantityKg) {
    }

    public double getPricePerKg() {
        return 0.0;
    }

    public void setPricePerKg(double pricePerKg) {
    }

    public String getSupplier() {
        return null;
    }

    public void setSupplier(String supplier) {
    }

    public LocalDate getLastRestockDate() {
        return null;
    }

    public void setLastRestockDate(LocalDate lastRestockDate) {
    }

    public LocalDate getExpiryDate() {
        return null;
    }

    public void setExpiryDate(LocalDate expiryDate) {
    }

    public double getMinStockLevel() {
        return 0.0;
    }

    public void setMinStockLevel(double minStockLevel) {
    }

    // Business methods

    /**
     * Check if feed stock is low
     * @return true if below minimum stock level
     */
    public boolean isLowStock() {
        return false;
    }

    /**
     * Check if feed is expired or near expiry
     * @return true if expired or expires within 7 days
     */
    public boolean isExpiredOrNearExpiry() {
        return false;
    }

    /**
     * Calculate total value of current stock
     * @return Total value in currency
     */
    public double getTotalValue() {
        return 0.0;
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