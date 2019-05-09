package com.example.amcontest.base.staticHelpers;

import android.content.Context;
import android.preference.PreferenceManager;

public class QueryPreferences {
    public static final String USER_NAME = "USER_NAME";
    public static final String USER_PHOTO = "USER_PHOTO";
    public static final String USER_EMAIL = "USER_EMAIL";

    public static String getUserName(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(USER_NAME, null);
    }
    public static void setUserName(Context context, String userName) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(USER_NAME, userName)
                .apply();
    }

    public static String getUrlPhoto(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(USER_PHOTO, null);
    }
    public static void setUrlPhoto(Context context, String urlPhoto) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(USER_PHOTO, urlPhoto)
                .apply();
    }

    public static String getUserEmail(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(USER_EMAIL, null);
    }
    public static void setUserEmail(Context context, String userEmail) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(USER_EMAIL, userEmail)
                .apply();
    }


}
