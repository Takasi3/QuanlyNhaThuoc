package com.tdc.quanlythuoctay.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tdc.quanlythuoctay.Adapter.BillAdapter;
import com.tdc.quanlythuoctay.Adapter.MedicineAdapter;
import com.tdc.quanlythuoctay.Adapter.PhamarAdapter;
import com.tdc.quanlythuoctay.Database.DatabaseHandler;
import com.tdc.quanlythuoctay.R;
import com.tdc.quanlythuoctay.model.BillModel;
import com.tdc.quanlythuoctay.model.PharmaModel;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class Bill extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
private Button btnBack,btnaddbill,btndeletebill,btnseach,btnReload;
private TextView tvDatetime,edtngaylap;
private ListView lstTBill;
private DatePickerDialog dpd;
    ArrayList<BillModel> dataList;
    BillAdapter adapter = null;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        db = new DatabaseHandler(Bill.this);
        btnBack =(Button) findViewById(R.id.btnBack3);
        btnaddbill =(Button) findViewById(R.id.btnaddbill);
        btndeletebill =(Button) findViewById(R.id.btndeletebill);
        btnReload = (Button) findViewById(R.id.btnReloadbill);
        btnseach= (Button) findViewById(R.id.btnseachbill);
        tvDatetime=(TextView)findViewById(R.id.tvDatetime);
        lstTBill = (ListView) findViewById(R.id.lstTBill);
        dataList = new ArrayList<>();
        if(db.getAllPharma() != null)
        {
            dataList = db.getAllBill();
        }
        adapter = new BillAdapter(this, R.layout.lstbill, dataList);
        lstTBill.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        setevent();
    }
    private void setevent()
    {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Bill.this, Menu.class));
                // close  activity
                finish();
            }
        });
        btndeletebill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteBill();
            }
        });
        btnseach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvDatetime.getText().toString().trim().length() ==0)
                {
                    return;
                }
                else
                {
                    dataList = db.SearchBill(tvDatetime.getText().toString().trim());
                    adapter = new BillAdapter(Bill.this, R.layout.lstbill, dataList);
                    lstTBill.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    btnReload.setVisibility(View.VISIBLE);
                }
            }
        });
        btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataList = db.getAllBill();
                adapter = new BillAdapter(Bill.this, R.layout.lstbill, dataList);
                lstTBill.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                btnReload.setVisibility(View.GONE);
            }
        });
        tvDatetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                now.add(Calendar.DATE,7);
                if (dpd == null) {
                    dpd = DatePickerDialog.newInstance(
                            Bill.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                } else {
                    dpd.initialize(
                           Bill.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                }

                dpd.setVersion(DatePickerDialog.Version.VERSION_2);
                dpd.setTitle("Chọn Ngày");
                dpd.setScrollOrientation(DatePickerDialog.ScrollOrientation.VERTICAL);
                dpd.setOnCancelListener(dialog -> {
                    Log.d("DatePickerDialog", "Dialog was cancelled");
                    dpd = null;
                });
                dpd.show(getSupportFragmentManager(),"Timepickerdialog");

            }
        });
    }
    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        tvDatetime.setText(date);
        if(edtngaylap!= null)
        {
            edtngaylap.setText(date);
        }
    }
    private void deleteBill()
    {
        int allsize = dataList.size();
        for (int i = dataList.size()-1; i >= 0 ; i--)
        {
            if (dataList.get(i).isChon())
            {
                db.deleteBill(dataList.get(i).getBillID());
                dataList.remove(i);
            }
        }
        int aftersize = dataList.size();
        if(allsize > aftersize)
        {
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(),"Xóa thành công !",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Vui lòng chọn bill để xoá !",Toast.LENGTH_SHORT).show();
        }



    }

}