package com.tdc.quanlythuoctay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tdc.quanlythuoctay.R;

public class Bill extends AppCompatActivity {
private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        btnBack =(Button) findViewById(R.id.btnBack3);

        setevernt();
    }
    private void setevernt()
    {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bill.this, Menu.class));
                // close  activity
                finish();
            }
        });
    }
}