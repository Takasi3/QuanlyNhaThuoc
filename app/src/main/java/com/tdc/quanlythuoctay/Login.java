package com.tdc.quanlythuoctay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
private Spinner spinerLanguage;
private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Ánh xạ

        spinerLanguage = (Spinner) findViewById(R.id.spinerLanguage);
        btnLogin = (Button) findViewById(R.id.btn_login);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Tiếng Việt");
        arrayList.add("English");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList );
        spinerLanguage.setAdapter(arrayAdapter);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Menu.class));
                // close splash activity
                finish();
            }
        });

    }
}