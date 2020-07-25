package com.tdc.quanlythuoctay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class Menu extends MainActivity {
private Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        //Ánh Xạ
        btnLogout = findViewById(R.id.btnLogout);
        SharedPreferences mPrefs = getSharedPreferences("user",0);
        final SharedPreferences.Editor editor = mPrefs.edit();
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit();
                startActivity(new Intent(Menu.this, Login.class));
                // close  activity
                finish();
            }
        });
    }
}