package com.tdc.quanlythuoctay.Activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.tdc.quanlythuoctay.R;
import com.tdc.quanlythuoctay.model.AccoutModel;

import java.util.ArrayList;
import java.util.Locale;

public class Login extends MainActivity {
    private Spinner spinerLanguage;
    private Button btnLogin,btndisplaying;
    private CheckBox cbSavePass;
    private EditText edtUser, edtPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getDefaults("language",getApplicationContext()) != null )// kiểm tra nếu dữ liệu 'user' khác null
        {
            Locale locale = new Locale(getDefaults("language",getApplicationContext()));
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
            getBaseContext().getResources().getDisplayMetrics());
        }
        setContentView(R.layout.activity_login);




        // Ánh xạ

        spinerLanguage = (Spinner) findViewById(R.id.spinerLanguage);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btndisplaying = (Button) findViewById(R.id.displaying);
        edtUser = (EditText) findViewById(R.id.input_email);
        edtPass = (EditText) findViewById(R.id.input_password);
        cbSavePass= (CheckBox) findViewById(R.id.cbSavePass);
        checkdata();// kiểm tra xem có thông tin đăng nhập sẵn không ?

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getString(R.string.chonnn));
        arrayList.add( getString(R.string.tv));
        arrayList.add(getString(R.string.ta));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList );
        spinerLanguage.setAdapter(arrayAdapter);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
        btndisplaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(Login.this);
                View promptsView = li.inflate(R.layout.popupcontent, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        Login.this);
                alertDialogBuilder.setView(promptsView);
                final AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        spinerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position == 1)
                {
                    setLanguage("vi-rVN",getApplicationContext());
                    Toast.makeText(Login.this,getString(R.string.changeNN),Toast.LENGTH_LONG).show();
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);

                }
                else if(position == 2)
                {
                    setLanguage("en",getApplicationContext());
                    Toast.makeText(Login.this,getString(R.string.changeNN),Toast.LENGTH_LONG).show();
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                    spinerLanguage.setSelection(0);
            }

        });

    }
    private void Login()
    {
        if(edtUser.getText().length() == 0  ||edtPass.getText().length() == 0 )
        {
            Toast.makeText(Login.this,getString(R.string.error1),Toast.LENGTH_LONG).show();
        }
        else
        {
            if(check(edtUser.getText().toString().trim(),edtPass.getText().toString().trim()))
            {
                if(cbSavePass.isChecked()) // nếu có check lưu mật khẩu
                {
                    // Lưu lại thông tin đăng nhập xuống máy
                    AccoutModel accoutModel= new AccoutModel();
                    accoutModel.setUser(edtUser.getText().toString());
                    accoutModel.setPass(edtPass.getText().toString());
                    setDefaults(accoutModel,getApplicationContext());
                }
                else
                {
                    // nếu không thì xoá dữ liệu cũ
                    removeDefaults(getApplicationContext());
                }
                Intent login = new Intent(Login.this, Menu.class);
                login.putExtra("ID",edtUser.getText().toString());
                startActivity(login);
                // close splash activity
                finish();

            }
            else
            {
                Toast.makeText(Login.this,getString(R.string.error2),Toast.LENGTH_LONG).show();
            }

        }
    }
    private boolean check(String user ,String Pass) {
        Boolean result = false;
        if (user.toUpperCase().equals("NHOM6")) {
            if (Pass.toUpperCase().equals("NHOM6")) {
                result = true;
            }
        } else if (user.equals("12345")) {
            if (Pass.equals("12345")) {
                result =  true;
            }
        }
        else
        {
            result = false;
        }
        return  result;

    }

    private void checkdata(){
        if(getDefaults("User",getApplicationContext()) != null )// kiểm tra nếu dữ liệu 'user' khác null
        {
                //set giá trị thông tin đăng nhập vào 2 editbox
            String user = getDefaults("User",getApplicationContext());
            String pass = getDefaults("Pass",getApplicationContext());
            edtUser.setText(user);
            edtPass.setText(pass);

        }
    }


}