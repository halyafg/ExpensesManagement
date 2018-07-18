package com.hal.expenses_management;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleOutputImpl implements ConsoleOutput {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }

    @Override
    public void printLine(String line) {
        System.out.print(line);
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void printLine (Map<Date, List<Purchase>> purchaseMap){
        purchaseMap.forEach((k, v) -> {
            printLine("\n\t" + sdf.format(k));
            v.forEach(p -> printLine("\n\t" + p));
            printLine("\n");
        });
    }

}
