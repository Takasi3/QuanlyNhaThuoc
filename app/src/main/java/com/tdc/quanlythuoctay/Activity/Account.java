package com.tdc.quanlythuoctay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.tdc.quanlythuoctay.R;

public class Account extends AppCompatActivity {
private Button btn_register,btnBackout;
private EditText input_email,input_password,input_repass;
private ImageButton imageAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        mapping();
        setEvent();
    }

 private void mapping()
 {
     btn_register = (Button) findViewById(R.id.btn_register);
     btnBackout = (Button) findViewById(R.id.btnBackout);
     input_email =(EditText) findViewById(R.id.input_email);
     input_password =(EditText) findViewById(R.id.input_password);
     input_repass =(EditText) findViewById(R.id.input_repass);
     imageAvatar=(ImageButton)findViewById(R.id.imageAvatar);

 }
 private void setEvent()
 {
     btnBackout.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent login = new Intent(Account.this, Login.class);
             startActivity(login);
             // close splash activity
             finish();
         }
     });
 }
}