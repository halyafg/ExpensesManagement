package com.hal.expenses_management;

import java.util.Arrays;

import static com.hal.expenses_management.Commands.*;
import static com.hal.expenses_management.Commands.CLEAR;
import static com.hal.expenses_management.Commands.TOTAL;
import static java.lang.String.valueOf;

public class ExpensesRunner {

    private final ConsoleOutput console;
    private final Expenses expenses;

    public ExpensesRunner(ConsoleOutput console, Expenses expenses) {
        this.console = console;
        this.expenses = expenses;
    }

    public void run() {

        console.printLine("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=\n" +
                "Hello from Expenses Management!\n" +
                "=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");


        while (true) {

            console.printLine("\nAvailable commands: " + Arrays.toString(values()) + "\n>>  ");

            String[] commandFromUser = console.getUserInput().split(" ");

            String command = commandFromUser[0].toUpperCase();

            if (command.equals(valueOf(EXIT)) && commandFromUser.length == 1) {

                break;

            } else if (command.equals(valueOf(ADD))) {

                expenses.addPurchase(commandFromUser);
                console.printLine(expenses.getPurchaseMap());

            } else if (command.equals(valueOf(LIST)) && commandFromUser.length == 1) {

                console.printLine(expenses.getPurchaseMap());

            } else if (command.equals(valueOf(CLEAR))) {

                expenses.deletePurchase(commandFromUser);
                console.printLine(expenses.getPurchaseMap());

            } else if (command.equals(valueOf(TOTAL))) {

                double counter = expenses.getTotalAmountInSpecifiedCurrency(commandFromUser);
                if (counter == 0) {
                    console.printLine("!!!  There is a mistake in currency's name");
                }
                console.printLine("\n\t" + counter + " " + commandFromUser[1].toUpperCase() + "\n");

            } else {

                console.printLine("!!!  Wrong Command! Try again ;-)\n");

            }

        }

        console.printLine("Bye!");
    }
}
