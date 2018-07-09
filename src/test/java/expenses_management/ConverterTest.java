package expenses_management;

import com.hal.expenses_management.Converter;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConverterTest {

    private final String CURRENCY_COD = "UAH";
    private final double EXPECTED_RATE_TO_EURO = 30.3;

    @Test
    @Ignore
    public void convertToBaseEUR() {
        double actualRate = Converter.convertToBaseEUR(CURRENCY_COD);
        assertEquals(EXPECTED_RATE_TO_EURO, actualRate, 0.3);
    }

}