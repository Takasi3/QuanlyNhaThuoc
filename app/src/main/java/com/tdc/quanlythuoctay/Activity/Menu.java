package com.tdc.quanlythuoctay.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tdc.quanlythuoctay.R;


public class Menu extends MainActivity {
private Button btnLogout,btnQLNT,btnQLT,btnHD;
private TextView tvID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Ánh Xạ

        btnLogout =(Button)  findViewById(R.id.btnLogout);
        btnQLNT = (Button) findViewById(R.id.btnQLNT);
        btnQLT =(Button)  findViewById(R.id.btnQLT);
        btnHD = (Button) findViewById(R.id.btnHD);
        tvID = (TextView) findViewById(R.id.tvID);
       Bundle extras = getIntent().getExtras();
         if (extras != null) {
              String idtext = getIntent().getExtras().getString("ID");
             tvID.setText(idtext);
             setID(idtext);
         }
         else
         {
             tvID.setText(getID());
         }

        setEvent();
    }

    private void setEvent() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeDefaults(getApplicationContext()); //Xoá thông tin đăng nhập khi đăng xuất
                startActivity(new Intent(Menu.this, Login.class));
                finish();
            }
        });
        btnQLNT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, lstPharmacy.class));
            }
        });
        btnQLT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, medicines.class));
            }
        });
        btnHD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, Bill.class));
            }
        });
    }
}