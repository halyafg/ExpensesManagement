package com.hal.expenses_management;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * this class contains methods to get actual currency's rate to Euro
 *
 * @author Halyna Hoy
 */
    class Converter {

    /**
     * this method returns actual currency's rate to Euro
     * using MY PERSONAL temporary key (can use the key up to 05.08.2018) from fixer.io.
     *
     * @param CurrencyCode - currency's cod (three letters) in ISO 4217
     * @return  - rate of 'CurrencyCode'  to EUR
     */
    public static double convertToBase_EUR(String CurrencyCode) {

        // API Provider URL
        final String API_PROVIDER = "http://data.fixer.io/api/latest?access_key=39adb84486efcfa03b4064fa6a0b9441&format=1";

        double conversionRate = 0;

        if ( (CurrencyCode != null && !CurrencyCode.isEmpty())) {

            CurrencyConversionResponse response = getResponseFromUrl(API_PROVIDER);

            if(response != null) {
                String rate = response.getRates().get(CurrencyCode);
                conversionRate = Double.valueOf((rate != null)?rate:"0.0");
            }
        }
        return conversionRate;
    }

    private static CurrencyConversionResponse getResponseFromUrl(String strUrl) {

        CurrencyConversionResponse response = null;

        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();

        if(strUrl == null || strUrl.isEmpty()) {

            System.out.println("Application Error");
            return null;
        }

        URL url;
        try {
            url = new URL(strUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();

            int data = stream.read();

            while (data != -1) {
                sb.append((char) data);
                data = stream.read();
            }

            stream.close();
            connection.disconnect();

            response = gson.fromJson(sb.toString(), CurrencyConversionResponse.class);

        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return response;
    }

}