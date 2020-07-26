package com.tdc.quanlythuoctay.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.tdc.quanlythuoctay.R;
import com.tdc.quanlythuoctay.model.AccoutModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    //Hàm lưu thông tin xuống máy
    public static void setDefaults(AccoutModel accout, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
            editor.putString("User", accout.getUser());
            editor.putString("Pass", accout.getPass());
            editor.commit();
    }

    //Hàm lấy thông tin từ máy
    public static String getDefaults(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }
    //Hàm xoá thông tin dưới máy
    public static void removeDefaults(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
    @Override
    public void onBackPressed() {
        xulythoat();
    }
    private  void xulythoat(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("EXIT");
        builder.setMessage("Bạn có muốn Thoát không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}