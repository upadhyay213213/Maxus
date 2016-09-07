package com.subcodevs.maxus.constants;

import android.text.TextUtils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by nupadhay on 5/12/2016.
 */
public class Contants {

    /**
     * Get formatted price.
     *
     * @param number String
     * @return String
     */
    public static String formatCompensation(String number) {
        if (TextUtils.isEmpty(number)) {
            return "";
        }
        String formattedPrice;
        NumberFormat numberFormat = NumberFormat.getInstance();
        formattedPrice = numberFormat.format(Long.parseLong(number));
        return formattedPrice;
    }


    public static String formatDecimal(float number) {
        double amount = 200.0;
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return (currencyFormatter.format(number));
    }
}
