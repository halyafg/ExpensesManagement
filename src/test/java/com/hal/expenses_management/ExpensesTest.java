package com.hal.expenses_management;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class ExpensesTest {

    @Test
    public void testAddOnePurchase() {

        Expenses expenses = new Expenses();
        String[] message = "add 2017-04-25 3 EUR “French fries”".split(" ");

        expenses.addPurchase(message);

        Map<String, List<Purchase>> expectedMap = new TreeMap<>();
        expectedMap.put("2017-04-25", Collections.singletonList(new Purchase("2017-04-25", 3, "EUR", "“French fries”")));

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
    public void testExtractPurchase() {

        Expenses expenses = new Expenses();
        String[] message = "add 2017-04-25 3 EUR “French fries”".split(" ");

        Purchase actual = expenses.extractPurchase(message);
        Purchase expected = new Purchase("2017-04-25", 3, "EUR", "“French fries”");

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


}