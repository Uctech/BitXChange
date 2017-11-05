package com.uctech.bitxchange.utils;


import com.uctech.bitxchange.model.Currency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by UcheAtSoftquest on 10/25/2017.
 */

public class DummyDataProvider {

    private  List<Currency> currencyList = new ArrayList<>();

    public  List<Currency> getData() {
        currencyList.add(new Currency("Nigerian Naira", "ngn/flag/icon", "NGN", new BigDecimal("34565775")));
        currencyList.add(new Currency("United states dollar", "usd/flag/icon", "USD", new BigDecimal("25657567")));
        currencyList.add(new Currency("Euro", "eur/flag/icon", "EUR", new BigDecimal("1965775")));
        currencyList.add(new Currency("Japanese Yen", "jpy/flag/icon", "JPY", new BigDecimal("1965775")));
        currencyList.add(new Currency("Algerian Dinar", "dzd/flag/icon", "DZD", new BigDecimal("174365649523")));
        currencyList.add(new Currency("West African CFA Franc", "xof/flag/icon", "XOF", new BigDecimal("12468987")));
        return currencyList;
    }


    public static String counryString = "USD,EUR,NGN,AUD";
}
