package com.tdc.quanlythuoctay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends MainActivity {
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private Spinner spinerLanguage;
    private Button btnLogin;
    private CheckBox cbSavePass;
    private EditText edtUser, edtPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        // Ánh xạ

        spinerLanguage = (Spinner) findViewById(R.id.spinerLanguage);
        btnLogin = (Button) findViewById(R.id.btn_login);
        edtUser = (EditText) findViewById(R.id.input_email);
        edtPass = (EditText) findViewById(R.id.input_password);
        cbSavePass= (CheckBox) findViewById(R.id.cbSavePass);
        initPreferences(); // Khai báo biến lưu giữ liệu
        checkdata();// kiểm tra xem có thông tin đăng nhập sẵn không ?

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
                Login();
            }
        });

    }
    private void Login()
    {
        if(edtUser.getText().length() == 0  ||edtPass.getText().length() == 0 )
        {
            Toast.makeText(Login.this,"Vui Lòng nhập đầy đủ tài khoản và mật khẩu !",Toast.LENGTH_LONG).show();
        }
        else
        {
            if(check(edtUser.getText().toString().trim(),edtPass.getText().toString().trim()))
            {
                if(cbSavePass.isChecked()) // nếu có check lưu mật khẩu
                {
                    // Lưu lại thông tin đăng nhập xuống máy
                    editor.putString("user",edtUser.getText().toString());
                    editor.putString("pass",edtPass.getText().toString());
                    editor.commit();
                }
                else
                {
                    // nếu không thì xoá dữ liệu cũ
                    editor.clear();
                    editor.commit();
                }
                startActivity(new Intent(Login.this, Menu.class));
                // close splash activity
                finish();

            }
            else
            {
                Toast.makeText(Login.this,"Taì khoản hoặc mật khẩu không chính xác !",Toast.LENGTH_LONG).show();
            }

        }
    }
    private boolean check(String user ,String Pass) {
        Boolean result = false;
        if (user.toUpperCase().equals("TAKASI3")) {
            if (Pass.equals("301097")) {
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
    public void initPreferences() {

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }
    private void checkdata(){
        if(!sharedPreferences.getString("user", "null").equals("null"))// kiểm tra nếu dữ liệu 'user' khác null
        {
                //set giá trị thông tin đăng nhập vào 2 editbox
            String user = sharedPreferences.getString("user", "");
            String pass = sharedPreferences.getString("pass", "");
            edtUser.setText(user);
            edtPass.setText(pass);


        }
    }
}