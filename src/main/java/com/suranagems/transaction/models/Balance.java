package com.suranagems.transaction.models;

public class Balance {
    private String partyName; // Ensure this has a getter
    private double metalBalance; // Ensure this has a getter
    private double cashBalance; // Ensure this has a getter

    // No-argument constructor
    public Balance() {
        this.partyName = "";
        this.metalBalance = 0.0;
        this.cashBalance = 0.0;
    }

    // Constructor with partyName
    public Balance(String partyName) {
        this.partyName = partyName;
        this.metalBalance = 0.0;
        this.cashBalance = 0.0;
    }

    // Getters and Setters
    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public double getMetalBalance() {
        return metalBalance;
    }

    public void setMetalBalance(double metalBalance) {
        this.metalBalance = metalBalance;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public void addMetal(double amount) {
        this.metalBalance += amount;
    }

    public void subtractMetal(double amount) {
        this.metalBalance -= amount;
    }

    public void addCash(double amount) {
        this.cashBalance += amount;
    }

    public void subtractCash(double amount) {
        this.cashBalance -= amount;
    }
}