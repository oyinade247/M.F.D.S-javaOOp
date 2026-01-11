package model;

public class Transaction {
    private String fuelName;
    private double liters;
    private double amount;

    public Transaction(String fuelName, double liters, double amount) {
        this.fuelName = fuelName;
        this.liters = liters;
        this.amount = amount;
    }

    public String getFuelName() {
        return fuelName;
    }

    public double getLiters() {
        return liters;
    }

    public double getAmount() {
        return amount;
    }
}

