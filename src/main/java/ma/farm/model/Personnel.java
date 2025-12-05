package ma.farm.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Personnel model - Represents farm workers
 * Used in: Personnel page
 */
public class Personnel {

    // Fields
    private int id;
    private String fullName;                // Worker full name
    private int age;                        // Worker age
    private String phone;                   // Contact phone
    private String email;                   // Contact email
    private String jobTitle;                // Worker, Tracker
    private LocalDate hireDate;             // Date hired
    private double salary;                  // Monthly salary
    private String shift;                   // Morning, Evening, Night
    private boolean isActive;               // Currently employed
    private String address;                 // Home address
    private String emergencyContact;        // Emergency contact info

    // Default constructor
    public Personnel() {
    }

    // Constructor for new personnel (MVP - minimal fields)
    public Personnel(String fullName, int age, String phone, String email, String jobTitle) {
    }

    // Full constructor
    public Personnel(int id, String fullName, int age, String phone, String email,
                     String jobTitle, LocalDate hireDate, double salary, String shift,
                     boolean isActive, String address, String emergencyContact) {
    }

    // Getters and Setters
    public int getId() {
        return 0;
    }

    public void setId(int id) {
    }

    public String getFullName() {
        return null;
    }

    public void setFullName(String fullName) {
    }

    public int getAge() {
        return 0;
    }

    public void setAge(int age) {
    }

    public String getPhone() {
        return null;
    }

    public void setPhone(String phone) {
    }

    public String getEmail() {
        return null;
    }

    public void setEmail(String email) {
    }

    public String getJobTitle() {
        return null;
    }

    public void setJobTitle(String jobTitle) {
    }

    public LocalDate getHireDate() {
        return null;
    }

    public void setHireDate(LocalDate hireDate) {
    }

    public double getSalary() {
        return 0.0;
    }

    public void setSalary(double salary) {
    }

    public String getShift() {
        return null;
    }

    public void setShift(String shift) {
    }

    public boolean isActive() {
        return false;
    }

    public void setActive(boolean active) {
    }

    public String getAddress() {
        return null;
    }

    public void setAddress(String address) {
    }

    public String getEmergencyContact() {
        return null;
    }

    public void setEmergencyContact(String emergencyContact) {
    }

    // Business methods

    /**
     * Calculate years of service
     * @return Number of years employed
     */
    public int getYearsOfService() {
        return 0;
    }

    /**
     * Check if worker is a tracker (supervisor)
     * @return true if job title is "Tracker"
     */
    public boolean isTracker() {
        return false;
    }

    /**
     * Check if worker is a regular worker
     * @return true if job title is "Worker"
     */
    public boolean isWorker() {
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