package com.miind;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPrefUtils {
    private static final String SHARED_PREF_FILENAME = "miind";

    private static SharedPreferences getSharedPreference() {
        return MiindApp.getAppContext().getSharedPreferences(SHARED_PREF_FILENAME, Context.MODE_PRIVATE);
    }

    public static String getString(String key, String defValue) {
        SharedPreferences sharedPreferences = getSharedPreference();
        if (sharedPreferences != null) {
            defValue = sharedPreferences.getString(key, defValue);
        }

        return defValue;
    }

    public static int getInt(String key, int defValue) {
        SharedPreferences sharedPreferences = getSharedPreference();
        if (sharedPreferences != null) {
            defValue = sharedPreferences.getInt(key, defValue);
        }

        return defValue;
    }

    public static long getLong(String key, long defValue) {
        SharedPreferences sharedPreferences = getSharedPreference();
        if (sharedPreferences != null) {
            defValue = sharedPreferences.getLong(key, defValue);
        }

        return defValue;
    }

    public static boolean getBool(String key, boolean defValue) {
        SharedPreferences sharedPreferences = getSharedPreference();
        return sharedPreferences != null && sharedPreferences.getBoolean(key, defValue);
    }

    public static void updateSharedPref(String key, int value) {
        SharedPreferences sharedPreferences = getSharedPreference();
        if (sharedPreferences != null && key != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(key, value);
            editor.commit();
        }
    }

    public static void updateSharedPref(String key, long value) {
        SharedPreferences sharedPreferences = getSharedPreference();
        if (sharedPreferences != null && key != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putLong(key, value);
            editor.commit();
        }
    }

    public static void updateSharedPref(String key, String value) {
        SharedPreferences sharedPreferences = getSharedPreference();
        if (sharedPreferences != null && key != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key, value);
            editor.commit();
        }
    }

    public static void updateSharedPref(String key, boolean value) {
        SharedPreferences sharedPreferences = getSharedPreference();
        if (sharedPreferences != null && key != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(key, value);
            editor.commit();
        }
    }
}