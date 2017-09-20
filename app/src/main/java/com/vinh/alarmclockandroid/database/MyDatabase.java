package com.vinh.alarmclockandroid.database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Admin on 9/5/2017.
 */

public class MyDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "quizdatabase_alarmproject.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
