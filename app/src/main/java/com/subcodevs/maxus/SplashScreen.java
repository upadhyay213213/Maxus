package com.subcodevs.maxus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.subcodevs.maxus.ui.HomeScreen;

/**
 * Created by nupadhay on 5/12/2016.
 */
public class SplashScreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, HomeScreen.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}