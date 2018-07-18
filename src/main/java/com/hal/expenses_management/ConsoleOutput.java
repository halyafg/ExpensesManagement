package com.hal.expenses_management;

import com.hal.expenses_management.Purchase;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ConsoleOutput {

    String getUserInput();

    void printLine(String line);

    void printLine(Map<Date, List<Purchase>> purchaseMap);

}
