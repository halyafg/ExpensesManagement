package com.hal.expenses_management;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) o;
        return Double.compare(purchase.amount, amount) == 0 &&
                Objects.equals(date, purchase.date) &&
                Objects.equals(currency, purchase.currency) &&
                Objects.equals(productName, purchase.productName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(date, amount, currency, productName);
    }
}
