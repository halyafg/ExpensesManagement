package expenses_management;

import com.hal.expenses_management.Expenses;
import com.hal.expenses_management.Purchase;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class ExpensesTest {
    private Expenses expenses = new Expenses();
    private String[] message1 = "add 2017-04-25 2 USD Jogurt".split(" ");
    private String[] message2 = "add 2017-04-25 3 EUR “French fries”".split(" ");
    private String[] message3 = "add 2017-04-27 4.75 EUR Beer".split(" ");
    private String[] message4 = "add 2017-04-26 2.5 PLN Sweets".split(" ");
    private String[] message5 = "clear 2017-04-27".split(" ");


    @Test
    public void addOnePurchase() {

        expenses.addPurchase(message1);

        Map<String, List<Purchase>> expectedMap = new TreeMap<>();
        expectedMap.put("2017-04-25", Collections.singletonList(new Purchase("2017-04-25", 2, "USD", "Jogurt")));

        assertEquals(expectedMap, expenses.getPurchaseMap());

    }

    @Test
    public void addSomePurchases() {

        expenses.addPurchase(message1);
        expenses.addPurchase(message2);
        expenses.addPurchase(message3);
        expenses.addPurchase(message4);

        assertEquals(3, expenses.getPurchaseMap().keySet().size());
    }

    @Test
    public void extractPurchase() {
        Purchase actual = expenses.extractPurchase(message1);
        Purchase expected = new Purchase("2017-04-25", 2, "USD", "Jogurt");

        // ?? or Purchase expected = new Purchase(message1[1], Double.parseDouble(message1[2]), message1[3], message1[4]);

        assertEquals(expected, actual);
    }

    // can I use some assert...  in one @Test?
    @Test
    public void deletePurchase() {

        expenses.addPurchase(message3);

        assertFalse(expenses.getPurchaseMap().isEmpty());

        expenses.deletePurchase(message5);

        assertTrue(expenses.getPurchaseMap().isEmpty());

    }


}