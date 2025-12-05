package ma.farm.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Medication model - Represents medication inventory
 * Used in: Storage page
 */
public class Medication {

    // Fields
    private int id;
    private String name;                    // Medication name
    private String type;                    // Vaccine, Antibiotic, Supplement
    private int quantity;                   // Number of units/doses
    private String unit;                    // ml, tablets, doses
    private double pricePerUnit;            // Cost per unit
    private String supplier;                // Supplier name
    private LocalDate purchaseDate;         // Purchase date
    private LocalDate expiryDate;           // Expiration date
    private int minStockLevel;              // Reorder threshold
    private String usage;                   // Usage instructions

    // Default constructor
    public Medication() {
    }

    // Constructor for new medication
    public Medication(String name, String type, int quantity, String unit) {
    }

    // Full constructor
    public Medication(int id, String name, String type, int quantity, String unit,
                      double pricePerUnit, String supplier, LocalDate purchaseDate,
                      LocalDate expiryDate, int minStockLevel, String usage) {
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

    public int getQuantity() {
        return 0;
    }

    public void setQuantity(int quantity) {
    }

    public String getUnit() {
        return null;
    }

    public void setUnit(String unit) {
    }

    public double getPricePerUnit() {
        return 0.0;
    }

    public void setPricePerUnit(double pricePerUnit) {
    }

    public String getSupplier() {
        return null;
    }

    public void setSupplier(String supplier) {
    }

    public LocalDate getPurchaseDate() {
        return null;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
    }

    public LocalDate getExpiryDate() {
        return null;
    }

    public void setExpiryDate(LocalDate expiryDate) {
    }

    public int getMinStockLevel() {
        return 0;
    }

    public void setMinStockLevel(int minStockLevel) {
    }

    public String getUsage() {
        return null;
    }

    public void setUsage(String usage) {
    }

    // Business methods

    /**
     * Check if medication stock is low
     * @return true if below minimum stock level
     */
    public boolean isLowStock() {
        return false;
    }

    /**
     * Check if medication is expired
     * @return true if past expiry date
     */
    public boolean isExpired() {
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