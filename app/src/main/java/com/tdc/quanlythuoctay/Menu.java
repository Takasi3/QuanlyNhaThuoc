package com.tdc.quanlythuoctay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {
private ListView listView;
private Button btndisplaying;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Ánh Xạ
        listView = (ListView) findViewById(R.id.lsvBXH);
        btndisplaying =(Button)findViewById(R.id.displaying);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("#1 : Nhà Thuốc An Khang");
        arrayList.add("#2 : Nhà Thuốc Long Châu");
        arrayList.add("#3 : Nhà Thuốc Sao Việt");
        arrayList.add("#4 : Nhà Thuốc Minh Phương");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList );
        listView.setAdapter(arrayAdapter);
        btndisplaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Menu.this, lstPharmacy.class));
                // close splash activity
            }
        });



    }
}