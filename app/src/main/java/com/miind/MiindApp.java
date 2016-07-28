package com.miind;

import android.app.Application;
import android.content.Context;

/**
 * Created by tringapps
 */

public class MiindApp extends Application {
    private static Context sContext;
    public static boolean sIsReleaseBuild;
    public static final String TAG = MiindApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();

    }

    public static Context getAppContext() {
        return sContext;
    }

}