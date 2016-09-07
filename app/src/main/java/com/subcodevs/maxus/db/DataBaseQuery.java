package com.subcodevs.maxus.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by nupadhay on 5/17/2016.
 */
public class DataBaseQuery {

    private static String getCalculation(Cursor cursor) {
        String  calculation = "";
        while (cursor.moveToNext()) {
            calculation = cursor.getString(cursor.getColumnIndexOrThrow("calculation"));

        }
        return calculation;

    }

    public static String getCalculation(String age, String salary) {
        Cursor cursor = getCalculationForGiveAgeAndSalary(age, salary);
        return getCalculation(cursor);

    }


    private static Cursor getCalculationForGiveAgeAndSalary(String age, String salary) {
        String query;
        query = "SELECT  calculation FROM table_pgbc WHERE age='" + age + "' and salary='" + salary + "'";
        SQLiteDatabase db = DatabaseHelper.getSqliteDatabase();
        Cursor cur = DatabaseHelper.executeSelectQuery(db, query, null);
        return cur;

    }
    private static Cursor getCalculationForGiveAgeAndSalaryNon(String age, String salary) {
        String query;
        query = "SELECT  calculations FROM table_non_pgbc WHERE age='" + age + "' and salary=' " + salary + " '";
        SQLiteDatabase db = DatabaseHelper.getSqliteDatabase();
        Cursor cur = DatabaseHelper.executeSelectQuery(db, query, null);
        return cur;

    }
    private static String getCalculationNon(Cursor cursor) {
        String  calculation = "";
        while (cursor.moveToNext()) {
            calculation = cursor.getString(cursor.getColumnIndexOrThrow("calculations"));

        }
        return calculation;

    }

    public static String getCalculationNon(String age, String salary) {
        Cursor cursor = getCalculationForGiveAgeAndSalaryNon(age, salary);
        return getCalculationNon(cursor);

    }



}
