package com.example.rxjavawithretrofitapplication;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
    }

    public static Context getAppContext(){
        return applicationContext;
    }
}
