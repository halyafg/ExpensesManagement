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
     * this method split the message, find new Purchase and add it to the Map
     *
     * @param purchaseMap - TreeMap of Purchases to add one
     * @param message - message from user in console
     */
    static void addPurchase(Map<String, List<Purchase>> purchaseMap, String message){

        String[] splitMessage = message.split(" ");

        String date = splitMessage[1];
        double amount =Double.parseDouble(splitMessage[2]);
        String currency = splitMessage[3];
        String productName = "";

        for (int i = NUMBER_OF_ELEMENTS_IN_ADD_COMMAND-1; i < splitMessage.length; i++) {
            productName = productName.concat(splitMessage[i]).concat(" ");
        }

        Purchase purchase = new Purchase(date, amount, currency, productName);

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
     * this method split the message, find the specified date,
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
     * this method split the message from user and calculate the total amount of money spent
     * but NOT (yet) present it to user in specified currency
     *
     * @param purchaseMap - TreeMap of Purchases
     * @param message - message from user in console
     */
    static void outputTotalAmountInCurrency(Map<String, List<Purchase>> purchaseMap, String message){

        String[] splitMessage = message.split(" ");

        if(splitMessage.length == 1){
            System.out.println("Input: total currency");
            return;
        }
        String currency = splitMessage[1];

        double counter = 0;

        for(Map.Entry<String, List<Purchase>> item: purchaseMap.entrySet()){
            for (Purchase purchase: item.getValue()) {
                    counter += purchase.getAmount();
            }
        }

        System.out.println("\t" + counter + " " + currency);
    }


    /**
     * this method output the list of all expenses sorted by date
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
