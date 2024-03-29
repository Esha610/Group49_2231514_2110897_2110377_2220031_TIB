package Shanto;

import java.util.Map;

public class Budget {
    
    private double totalAmount;
    private String currency;
    private Map<String, Double> allocation;
    private String name;
    private double amount;

    // Constructor for total budget
    public Budget(double totalAmount, String currency) {
        this.totalAmount = totalAmount;
        this.currency = currency;
    }
    
    // Constructor for detailed budget items
    public Budget(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    // Getters and setters for total amount and currency
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // Getters and setters for allocation map
    public Map<String, Double> getAllocation() {
        return allocation;
    }

    public void setAllocation(Map<String, Double> allocation) {
        this.allocation = allocation;
    }
    
    // Getters and setters for individual budget items
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }    
}
