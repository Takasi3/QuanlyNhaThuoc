package com.tdc.quanlythuoctay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashscreen extends AppCompatActivity {
    private static int TIME_OUT = 2000; //Time to launch the another activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start home activity
                startActivity(new Intent(splashscreen.this, Login.class));
                // close splash activity
                finish();
            }
        }, TIME_OUT);
    }
}