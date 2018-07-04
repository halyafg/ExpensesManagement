package com.hal.expenses_management;

/**
 * Simple object that represents purchase for user.
 *
 * @author Halyna Hoy
 * @version 1.0
 */
public class Purchase {

    private String date;
    private double amount;
    private String currency;
    private String productName;

    public Purchase() {
    }

    public Purchase(String date, double amount, String currency, String productName) {
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.productName = productName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return productName + " " + amount + " " + currency;

    }
}
