package com.hal.expenses_management;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConverterTest {

    @Test
    @Ignore
    public void convertToBaseEUR() {

        String CURRENCY_COD = "UAH";
        double EXPECTED_RATE_TO_EURO = 30.3;

        double actualRate = Converter.convertToBaseEUR(CURRENCY_COD);
        assertEquals(EXPECTED_RATE_TO_EURO, actualRate, 0.3);
    }

}