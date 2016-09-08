package com.example.user.todolist;

/**
 * Created by user on 07/09/2016.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

public class SavedTextPreferences {
//    private static final String PREF_SAVEDTEXT = "savedText";

    public static void setStoredText(Context context, String key, String text) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key, text);
        editor.apply();
    }

    public static String getStoredText(Context context, String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getString(key, null);
    }


}