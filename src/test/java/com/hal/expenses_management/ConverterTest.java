package com.hal.expenses_management;

import com.hal.expenses_management.currencyConverter.Converter;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConverterTest {

    /**
     * the result of this test depends on actual rate of some currencies (12.07.2017 it ran well)
     * that's why it's marked as @Ignore
     */
    @Test
    @Ignore
    public void convertToBaseEUR() {

        String CURRENCY_COD = "UAH";
        double EXPECTED_RATE_TO_EURO = 30.3;

        double actualRate = Converter.convertToBaseEUR(CURRENCY_COD);
        assertEquals(EXPECTED_RATE_TO_EURO, actualRate, 0.3);
    }

}