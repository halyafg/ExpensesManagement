package com.hal.expenses_management;

import java.util.*;

/**
 * Personal expenses management console application that allows
 * users to track how much money have they spent.
 *
 * @author Halyna Hoy
 * @version 1.0
 */
public class Application {
    public static void main(String[] args) {

        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
        System.out.println("Hello from Expenses Management!");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

        Scanner scanner = new Scanner(System.in);
        Map<String, List<Purchase>> purchaseMap= new TreeMap<>();

        while(true){

            System.out.print("\nAvailable commands: " + Arrays.toString(Commands.values()) + ".\n>>  ");

            String message = scanner.nextLine();

            if(message.equalsIgnoreCase(String.valueOf(Commands.EXIT))){
                break;
            }else
                if(message.toUpperCase().startsWith(String.valueOf(Commands.ADD))){
                    Methods.addPurchase(purchaseMap, message);
            }else
                if(message.toUpperCase().startsWith(String.valueOf(Commands.LIST))){
                    Methods.outputPurchaseMap(purchaseMap);
            }else
                if(message.toUpperCase().startsWith(String.valueOf(Commands.CLEAR))){
                    Methods.deletePurchase(purchaseMap, message);
            }else
                if(message.toUpperCase().startsWith(String.valueOf(Commands.TOTAL))){
                    Methods.outputTotalAmountInCurrency(purchaseMap, message);
            }else
                    System.out.println("Wrong Command! Try again ;-)");


        }

        scanner.close();
        System.out.println("Bye!");

    }

}
