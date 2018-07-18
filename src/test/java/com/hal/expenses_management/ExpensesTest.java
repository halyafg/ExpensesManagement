package com.hal.expenses_management;

import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ExpensesTest {

    @Test
    public void testAddOnePurchase() {

        Expenses expenses = new Expenses();
        String[] message = "add 2017-04-25 3 EUR “French fries”".split(" ");

        expenses.addPurchase(message);

        Map<Date, List<Purchase>> expectedMap = new TreeMap<>();
        Date date = new GregorianCalendar(2017, Calendar.APRIL, 25).getTime();
        expectedMap.put(date, Collections.singletonList(new Purchase(date, 3, "EUR", "“French fries”")));

        assertEquals(expectedMap, expenses.getPurchaseMap());
    }

    @Test
    public void testAddSomePurchases() {

        Expenses expenses = new Expenses();
        String[] message1 = "add 2017-04-25 2 USD Jogurt".split(" ");
        String[] message2 = "add 2017-04-25 3 EUR “French fries”".split(" ");
        String[] message3 = "add 2017-04-27 4.75 EUR Beer".split(" ");
        String[] message4 = "add 2017-04-26 2.5 PLN Sweets".split(" ");

        expenses.addPurchase(message1);
        expenses.addPurchase(message2);
        expenses.addPurchase(message3);
        expenses.addPurchase(message4);

        assertEquals(3, expenses.getPurchaseMap().keySet().size());
    }

    @Test
    public void testExtractDate() {
        Expenses expenses = new Expenses();
        String stringDate = "2017-04-25";

        Date actualDate = expenses.extractDate(stringDate);
        Date expectedDate = new GregorianCalendar(2017, Calendar.APRIL, 25).getTime();

        assertEquals(expectedDate, actualDate);

    }

    @Test
    public void testExtractPurchase() {

        Expenses expenses = new Expenses();
        String[] message = "add 2017-04-25 3 EUR “French fries”".split(" ");

        Purchase actual = expenses.extractPurchase(message);
        Date date = new GregorianCalendar(2017, Calendar.APRIL, 25).getTime();
        Purchase expected = new Purchase(date, 3, "EUR", "“French fries”");

        assertEquals(expected, actual);
    }

    @Test
    public void testDeletePurchase() {

        Expenses expenses = new Expenses();
        String[] message1 = "add 2017-04-25 3 EUR “French fries”".split(" ");
        String[] message2 = "clear 2017-04-25".split(" ");

        expenses.addPurchase(message1);

        assertFalse(expenses.getPurchaseMap().isEmpty());

        expenses.deletePurchase(message2);

        assertTrue(expenses.getPurchaseMap().isEmpty());

    }

    /**
     * the result of this test depends on actual rate of some currencies (12.07.2017 it ran well)
     * that's why it's marked as @Ignore
     */
    @Test
    @Ignore
    public void testGetTotalAmountInCurrency() {
        Expenses expenses = new Expenses();
        String[] message1 = "add 2017-04-25 2 USD Jogurt".split(" ");
        String[] message2 = "add 2017-04-25 3 EUR “French fries”".split(" ");
        String[] message3 = "add 2017-04-26 2.5 PLN Sweets".split(" ");
        String[] message4 = "total EUR".split(" ");
        double expectedTotal = 5.42;

        expenses.addPurchase(message1);
        expenses.addPurchase(message2);
        expenses.addPurchase(message3);

        double actualTotal = expenses.getTotalAmountInSpecifiedCurrency(message4);

        assertEquals(expectedTotal, actualTotal, 0.2);

    }


}