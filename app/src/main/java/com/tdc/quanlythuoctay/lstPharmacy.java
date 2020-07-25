package com.tdc.quanlythuoctay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class lstPharmacy extends AppCompatActivity {
    private ListView lstMnt,lstTenNT,lstDiaChi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_pharmacy);

        lstMnt = (ListView) findViewById(R.id.lvMnt);
        lstTenNT = (ListView) findViewById(R.id.lvTennt);
        lstDiaChi = (ListView) findViewById(R.id.lvdiachi);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(" Nhà Thuốc An Khang");
        arrayList.add("Nhà Thuốc Long Châu");
        arrayList.add("Nhà Thuốc Sao Việt");
        arrayList.add("Nhà Thuốc Minh Phương");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList );
        lstTenNT.setAdapter(arrayAdapter);



        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("NT 01");
        arrayList2.add("NT 02");
        arrayList2.add("NT 03");
        arrayList2.add("NT 04");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList2 );
        lstMnt.setAdapter(arrayAdapter2);



        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("123 Võ Văn Ngân");
        arrayList3.add("43 Nguyễn Chí Thanh");
        arrayList3.add("37 Lê Văn Việt");
        arrayList3.add("1148 TL 43");

        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList3 );

        lstDiaChi.setAdapter(arrayAdapter3);


    }
}