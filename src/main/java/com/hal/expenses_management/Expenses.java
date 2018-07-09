package com.hal.expenses_management;

import java.util.*;

/**
 * @author Halyna Hoy
 */
public class Expenses {

    private Map<String, List<Purchase>> purchaseMap;

    public Expenses() {
        this.purchaseMap = new TreeMap<>();
//        this.purchaseMap = new HashMap<>();
    }

    private final static int NUMBER_OF_ELEMENTS_IN_ADD_COMMAND = 5;

    public Map<String, List<Purchase>> getPurchaseMap() {
        return purchaseMap;
    }

    public void setPurchaseMap(Map<String, List<Purchase>> purchaseMap) {
        this.purchaseMap = purchaseMap;
    }

    /**
     * this method adds new Purchase to the Map
     *
     * @param message - message from user in console
     */
    public void addPurchase(String[] message) {

        Purchase purchase = extractPurchase(message);
        if (purchase == null) {
            return;
        }

        purchaseMap.putIfAbsent(purchase.getDate(), new ArrayList<>());
        Objects.requireNonNull(purchaseMap.putIfAbsent(purchase.getDate(), new ArrayList<>())).add(purchase);

        outputPurchaseMap();

    }

    /**
     * this method gets new Purchase from array message
     *
     * @param message - message from user in console
     * @return new Purchase
     */
    public Purchase extractPurchase(String[] message) {

        if (message.length < NUMBER_OF_ELEMENTS_IN_ADD_COMMAND) {
            return null;
        }

        String date = message[1];

        double amount = 0;
        try {
            amount = Double.parseDouble(message[2]);
        } catch (NumberFormatException e) {
            System.out.println("Wrong amount: " + message[2]);
        }

        String currency = message[3];

        String productName = "";
        for (int i = NUMBER_OF_ELEMENTS_IN_ADD_COMMAND - 1; i < message.length; i++) {
            productName = productName.concat(message[i]).concat(" ");
        }

        return new Purchase(date, amount, currency, productName.trim());
    }

    /**
     * this method removes all expenses for specified date.
     *
     * @param message - message from user in console
     */
    public void deletePurchase(String[] message) {

        if (message.length > 1) {
            String date = message[1];
            purchaseMap.remove(date);
        }

        outputPurchaseMap();
    }

    /**
     * this method calculates the total amount of money spent and presents it to user in specified currency
     *
     * @param message - message from user in console
     */
    public void outputTotalAmountInCurrency(String[] message) {

        //get specified currency from message
        if (message.length == 1) {
            System.out.println("Input: TOTAL currencyCOD");
            return;
        }
        String specifiedCurrency = message[1];

        double RateOfSpecifiedCurrency = Converter.convertToBaseEUR(specifiedCurrency.toUpperCase());

        double counter = 0;

        //calculates the total amount in specified currency
        for (Map.Entry<String, List<Purchase>> item : purchaseMap.entrySet()) {
            for (Purchase purchase : item.getValue()) {

                double rate = Converter.convertToBaseEUR(purchase.getCurrency().toUpperCase());
                if (rate == 0) {
                    System.out.println("No such currency according to ISO: " + purchase.getCurrency());
                    continue;
                }

                counter += RateOfSpecifiedCurrency / rate * purchase.getAmount();
            }
        }

        System.out.printf("\t%.2f %s", counter, specifiedCurrency.toUpperCase());
    }


    /**
     * output the list of all expenses sorted by date
     */
    public void outputPurchaseMap() {

        purchaseMap.forEach((k, v) -> {
            System.out.println("\n\t" + k);
            v.forEach(p -> System.out.println("\t" + p));
        });

    }

}
