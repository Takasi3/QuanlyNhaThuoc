package com.tdc.quanlythuoctay.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tdc.quanlythuoctay.R;


public class Menu extends MainActivity {
private Button btnLogout,btnQLNT,btnQLT,btnHD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Ánh Xạ
        btnLogout = findViewById(R.id.btnLogout);
        btnQLNT = findViewById(R.id.btnQLNT);
        btnQLT = findViewById(R.id.btnQLT);
        btnHD = findViewById(R.id.btnHD);

        setEvent();



    }

    private void setEvent() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeDefaults(getApplicationContext()); //Xoá thông tin đăng nhập khi đăng xuất
                startActivity(new Intent(Menu.this, Login.class));
                // close  activity
                finish();
            }
        });
        btnQLNT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, lstPharmacy.class));
                // close  activity
            }
        });
    }
}