package com.example.musician.voicecalculator;

import android.content.Context;
import android.content.SharedPreferences;

public class sharedpref {

    private static sharedpref yourPreference;
    private SharedPreferences sharedPreferences;

    public static sharedpref getInstance(Context context) {
        if (yourPreference == null) {
            yourPreference = new sharedpref(context);
        }
        return yourPreference;
    }

    private sharedpref(Context context) {
        sharedPreferences = context.getSharedPreferences("YourCustomNamedPreference",Context.MODE_PRIVATE);
    }

    public void checked() {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor .putBoolean("switch",true);
        prefsEditor.apply();
    }
    public void nochecked() {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor .putBoolean("switch",false);
        prefsEditor.apply();
    }

    public boolean getData(String key) {
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(key, false);
        }
        return false;
    }
}