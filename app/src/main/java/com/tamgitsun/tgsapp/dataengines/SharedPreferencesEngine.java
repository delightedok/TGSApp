package com.tamgitsun.tgsapp.dataengines;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesEngine {

    static final String DEFAULT_NAME = "main";

    static public void savedData(Context context, String name, String key, String value) {
        if (null == name) {
            name = DEFAULT_NAME;
        }
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    static public void savedData(Context context, String name, String key, int value) {
        if (null == name) {
            name = DEFAULT_NAME;
        }
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    static public void savedData(Context context, String name, String key, float value) {
        if (null == name) {
            name = DEFAULT_NAME;
        }
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    static public void savedData(Context context, String name, String key, boolean value) {
        if (null == name) {
            name = DEFAULT_NAME;
        }
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    static public String getStringData(Context context, String name, String key, String defaultValue) {
        if (null == name) {
            name = DEFAULT_NAME;
        }
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getString(key, defaultValue);
    }

    static public int getIntData(Context context, String name, String key, int defaultValue) {
        if (null == name) {
            name = DEFAULT_NAME;
        }
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getInt(key, defaultValue);
    }

    static public float getFloatData(Context context, String name, String key, float defaultValue) {
        if (null == name) {
            name = DEFAULT_NAME;
        }
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getFloat(key, defaultValue);
    }

    static public boolean getBooleanData(Context context, String name, String key, boolean defaultValue) {
        if (null == name) {
            name = DEFAULT_NAME;
        }
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defaultValue);
    }
}
