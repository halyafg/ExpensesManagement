package com.hal.expenses_management.currencyConverter;

import java.util.Map;
import java.util.TreeMap;

/**
 * Simple object.
 *
 * @author Halyna Hoy
 * @version 1.0
 */
public class CurrencyConversionResponse {

    private String base;
    private String date;

    private Map<String, String> rates = new TreeMap<>();

    public Map<String, String> getRates() {
        return rates;
    }

    public void setRates(Map<String, String> rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
