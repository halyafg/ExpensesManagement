package com.hal.expenses_management;

import static java.lang.String.valueOf;

/**
 * Personal expenses management console application that allows
 * users to track how much money have they spent.
 *
 * @author Halyna Hoy
 * @version 1.0
 */
public class Application {
    public static void main(String[] args) {

        ExpensesRunner expensesRunner = new ExpensesRunner(new ConsoleOutputImpl(), new Expenses());
        expensesRunner.run();

    }

}
