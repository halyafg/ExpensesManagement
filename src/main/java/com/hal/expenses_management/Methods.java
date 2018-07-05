package com.hal.expenses_management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * methods for main Application {@link com.hal.expenses_management.Application}.
 *
 * @author Halyna Hoy
 * @version 1.0
 */
class Methods {

    final static int NUMBER_OF_ELEMENTS_IN_ADD_COMMAND =5;

    /**
     * this method adds new Purchase to the Map
     *
     * @param purchaseMap - TreeMap of Purchases to add one
     * @param message - message from user in console
     */
    static void addPurchase(Map<String, List<Purchase>> purchaseMap, String message){

        Purchase purchase = getPurchase(message);

        if(purchaseMap.containsKey(purchase.getDate())){

            List<Purchase> temporaryList = purchaseMap.get(purchase.getDate());
            temporaryList.add(purchase);

            purchaseMap.put(purchase.getDate(),temporaryList);

        }else{
            List<Purchase> temporaryList = new ArrayList<>();
            temporaryList.add(purchase);

            purchaseMap.put(purchase.getDate(),temporaryList);
        }

       outputPurchaseMap(purchaseMap);

    }

    /**
     * this method splits the message from user in console and gets new Purchase
     *
     * @param message - message from user in console
     * @return new Purchase
     */
    static Purchase getPurchase (String message){

        String[] splitMessage = message.split(" ");

        String date = splitMessage[1];
        double amount = 0;

        try {
            amount = Double.parseDouble(splitMessage[2]);
        }catch (NumberFormatException e){
            System.out.println("Wrong amount: " + splitMessage[2]);
        }

        String currency = splitMessage[3];
        String productName = "";

        for (int i = NUMBER_OF_ELEMENTS_IN_ADD_COMMAND-1; i < splitMessage.length; i++) {
            productName = productName.concat(splitMessage[i]).concat(" ");
        }

        return new Purchase(date, amount, currency, productName.trim());
    }

    /**
     * this method splits the message, gets the specified date,
     * for which all expenses should be removed
     *
     * @param purchaseMap - TreeMap of Purchases to delete from
     * @param message - message from user in console
     */
    static void deletePurchase(Map<String, List<Purchase>> purchaseMap, String message){

        String[] splitMessage = message.split(" ");

        if(splitMessage.length > 1){
            String date = splitMessage[1];
            purchaseMap.remove(date);
        }

        outputPurchaseMap(purchaseMap);
    }

    /**
     * this method splits the message from user and calculates the total amount of money spent
     * and present it to user in specified currency
     *
     * @param purchaseMap - TreeMap of Purchases
     * @param message - message from user in console
     */
    static void outputTotalAmountInCurrency(Map<String, List<Purchase>> purchaseMap, String message){

        String[] splitMessage = message.split(" ");

        if(splitMessage.length == 1){
            System.out.println("Input: TOTAL currencyCOD");
            return;
        }
        String specifiedCurrency = splitMessage[1];
        double RateOfSpecifiedCurrency = Converter.convertToBase_EUR(specifiedCurrency.toUpperCase());

        double counter = 0;

        //calculates the total amount in specified currency
        for(Map.Entry<String, List<Purchase>> item: purchaseMap.entrySet()){
            for (Purchase purchase: item.getValue()) {

                double rate = Converter.convertToBase_EUR(purchase.getCurrency().toUpperCase());
                if (rate == 0) continue;

                counter += RateOfSpecifiedCurrency/rate * purchase.getAmount();
            }
        }

        System.out.printf("\t%.2f %s" , counter, specifiedCurrency);
    }


    /**
     * output the list of all expenses sorted by date
     *
     * @param purchaseMap - TreeMap of Purchases
     */
    static void outputPurchaseMap(Map<String, List<Purchase>> purchaseMap){

        purchaseMap.forEach((k, v) -> {
            System.out.println("\n\t" + k);
            v.forEach((p)-> System.out.println("\t" + p));
        });

    }

}
