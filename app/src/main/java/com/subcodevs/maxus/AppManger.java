package com.subcodevs.maxus;

import android.app.Application;

/**
 * Created by nupadhay on 5/12/2016.
 */
public class AppManger extends Application {

    public static AppManger mApplicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
         mApplicationContext=this;
    }

    public AppManger getContext(){
        return mApplicationContext;
    }

}
