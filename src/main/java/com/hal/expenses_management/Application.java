package com.hal.expenses_management;

import java.util.Arrays;
import java.util.Scanner;

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
        Expenses expenses = new Expenses();

        while (true) {

            System.out.print("\nAvailable commands: " + Arrays.toString(Commands.values()) + ".\n>>  ");

            String[] commandFromUser = scanner.nextLine().split(" ");

            String command = commandFromUser[0];


            if (command.equalsIgnoreCase(String.valueOf(Commands.EXIT)) && commandFromUser.length == 1) {
                break;
            } else if (command.equalsIgnoreCase(String.valueOf(Commands.ADD))) {
                expenses.addPurchase(commandFromUser);
            } else if (command.equalsIgnoreCase(String.valueOf(Commands.LIST)) && commandFromUser.length == 1) {
                expenses.outputPurchaseMap();
            } else if (command.toUpperCase().startsWith(String.valueOf(Commands.CLEAR))) {
                expenses.deletePurchase(commandFromUser);
            } else if (command.toUpperCase().startsWith(String.valueOf(Commands.TOTAL))) {
                expenses.outputTotalAmountInCurrency(commandFromUser);
            } else {
                System.out.println("Wrong Command! Try again ;-)");
            }

        }

        scanner.close();
        System.out.println("Bye!");

    }

}
