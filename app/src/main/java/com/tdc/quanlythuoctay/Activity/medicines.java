package com.tdc.quanlythuoctay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.tdc.quanlythuoctay.Adapter.MedicineAdapter;
import com.tdc.quanlythuoctay.Adapter.PhamarAdapter;
import com.tdc.quanlythuoctay.R;
import com.tdc.quanlythuoctay.model.MedicinesModel;
import com.tdc.quanlythuoctay.model.PharmaModel;

import java.util.ArrayList;

public class medicines extends MainActivity {
    private ListView lstThuoc;
    private Button btnBack,btnadd,btnedit,btndelete;
    ArrayList<MedicinesModel> dataList = new ArrayList<>();
    MedicineAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicines);

        lstThuoc = (ListView) findViewById(R.id.lstThuoc);
        btnBack = (Button) findViewById(R.id.btnBack2);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnedit = (Button) findViewById(R.id.btnedit);
        btndelete = (Button) findViewById(R.id.btndelete );

        adapter = new MedicineAdapter(this, R.layout.lstthuoc, dataList);
        lstThuoc.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstThuoc.setAdapter(adapter);

        for(int  i = 1 ; i<= 12 ; i++)
        {
            MedicinesModel medicinesModel = new MedicinesModel();
            medicinesModel.setMaThuoc(String.valueOf(i));
            if(i == 1 ||i == 5 || i == 9 )
            {
                medicinesModel.setTenThuoc("Paracetamol");
                medicinesModel.setDonGia("50.000 Vnd");
                medicinesModel.setDonVi("Hộp");
            }
            if(i == 2 ||i == 6 || i == 10 )
            {
                medicinesModel.setTenThuoc("L-Cystine 500mg 60 viên");
                medicinesModel.setDonGia(" 2.000 Vnd");
                medicinesModel.setDonVi("Viên");
            }
            if(i == 3 ||i == 7 || i == 11 )
             {
                medicinesModel.setTenThuoc("Anticid 500mg");
                 medicinesModel.setDonGia(" 450.000 Vnd");
                medicinesModel.setDonVi("Viên");
            }
            if(i == 4  ||i == 8 || i == 12 )
             {
                medicinesModel.setTenThuoc("Hoạt huyết dưỡng não Traphaco");
                 medicinesModel.setDonGia("23.000 Vnd");
                medicinesModel.setDonVi("Hộp");
            }
            dataList.add(medicinesModel);
        }
        adapter.notifyDataSetChanged();

        setEvent();
    }
    private void setEvent()
    {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(medicines.this, Menu.class));
                // close  activity
                finish();
            }
        });
    }
}