package com.tdc.quanlythuoctay.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.collection.LongSparseArray;

import com.tdc.quanlythuoctay.Adapter.PhamarAdapter;
import com.tdc.quanlythuoctay.R;
import com.tdc.quanlythuoctay.model.PharmaModel;

import java.util.ArrayList;

public class lstPharmacy extends MainActivity {
    private ListView lstNT;
    private Button btnBack,btnadd,btnedit,btndelete;
    private ImageButton btnMap;
    ArrayList<PharmaModel> dataList = new ArrayList<>();
    PhamarAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_pharmacy);
        //1. khai bao thong tin


        //2. setAdapter listview
        lstNT = (ListView) findViewById(R.id.lstNT);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnedit = (Button) findViewById(R.id.btnedit);
        btndelete = (Button) findViewById(R.id.btndelete );
        btnMap = (ImageButton) findViewById(R.id.btnMap);
        adapter = new PhamarAdapter(this, R.layout.lsttennt, dataList);
        lstNT.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstNT.setAdapter(adapter);

        //3. xu ly thong tin

        for(int i = 1 ; i <= 10 ; i++)
        {
            PharmaModel pharma = new PharmaModel();
            pharma.setMaNT(String.valueOf(i));
            pharma.setTenNT("Nhà thuốc An Khang-" + i);
            pharma.setDiaChi(" 53 Võ Văn Ngân "+i);
            //4. đưa danh sách
            dataList.add(pharma);
        }

        adapter.notifyDataSetChanged();// chu y

        setEvent();


    }
    private void setEvent()
    {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(lstPharmacy.this, Menu.class));
                // close  activity
                finish();
            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(lstPharmacy.this, MapsActivity.class));
                // close  activity
       
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletePhamar();
            }
        });

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int check = 0;
                int row = 0;
                for (int i = dataList.size()-1; i >= 0 ; i--)
                {
                    if (dataList.get(i).isChon())
                    {
                        check++;
                        row = i;
                    }
                }
                if(check ==0)
                {
                    Toast.makeText(lstPharmacy.this,"Vui Lòng chọn nhà thuốc để chỉnh sửa ",Toast.LENGTH_SHORT).show();
                }
                else if( check > 1)
                {
                    Toast.makeText(lstPharmacy.this,"Vui Lòng chọn chỉ chọn 1 nhà thuốc  ",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    LayoutInflater li = LayoutInflater.from(lstPharmacy.this);
                    View promptsView = li.inflate(R.layout.popupaddandedit, null);
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                            lstPharmacy.this);
                    alertDialogBuilder.setView(promptsView);

                    final EditText edtmaNT = (EditText) promptsView
                            .findViewById(R.id.edtmaNT);
                    final EditText edtTenNT = (EditText) promptsView
                            .findViewById(R.id.edttenNT);
                    final EditText edtDiaChi = (EditText) promptsView
                            .findViewById(R.id.edtDiaChi);
                    final Button btnEDIT = (Button) promptsView
                            .findViewById(R.id.btnpopupedit);
                    final Button btnADD = (Button) promptsView
                            .findViewById(R.id.btnpopupadd);
                    final Button btnCancel = (Button) promptsView
                            .findViewById(R.id.btnpopupcancel);
                    edtmaNT.setText(dataList.get(row).getMaNT());
                    edtTenNT.setText(dataList.get(row).getTenNT());
                    edtDiaChi.setText(dataList.get(row).getDiaChi());

                    final AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialogBuilder
                            .setCancelable(false);

                    btnADD.setVisibility(View.GONE);
                    btnEDIT.setVisibility(View.VISIBLE);


                    final int finalRow = row;
                    btnEDIT.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            PharmaModel pharma = new PharmaModel();
                            pharma.setMaNT(edtmaNT.getText().toString());
                            pharma.setTenNT(edtTenNT.getText().toString());
                            pharma.setDiaChi(edtDiaChi.getText().toString());
                            dataList.set(finalRow,pharma);
                            adapter.notifyDataSetChanged();
                            Toast.makeText(lstPharmacy.this,"Sửa Thành Công !",Toast.LENGTH_LONG).show();
                            alertDialog.cancel();

                        }
                    });
                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            alertDialog.cancel();
                        }
                    });
                    alertDialog.setCanceledOnTouchOutside(false);

                    // show it
                    alertDialog.show();
                }

            }
        });


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(lstPharmacy.this);
                View promptsView = li.inflate(R.layout.popupaddandedit, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        lstPharmacy.this);
                alertDialogBuilder.setView(promptsView);

                final EditText edtmaNT = (EditText) promptsView
                        .findViewById(R.id.edtmaNT);
                final EditText edtTenNT = (EditText) promptsView
                        .findViewById(R.id.edttenNT);
                final EditText edtDiaChi = (EditText) promptsView
                        .findViewById(R.id.edtDiaChi);
                final Button btnADD = (Button) promptsView
                        .findViewById(R.id.btnpopupadd);
                final Button btnCancel = (Button) promptsView
                        .findViewById(R.id.btnpopupcancel);
                final Button btnEDIT = (Button) promptsView
                        .findViewById(R.id.btnpopupedit);
                btnEDIT.setVisibility(View.GONE);
                btnADD.setVisibility(View.VISIBLE);
                final AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialogBuilder
                        .setCancelable(false);

                btnADD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        PharmaModel pharma = new PharmaModel();
                        pharma.setMaNT(edtmaNT.getText().toString());
                        pharma.setTenNT(edtTenNT.getText().toString());
                        pharma.setDiaChi(edtDiaChi.getText().toString());
                        dataList.add(pharma);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(lstPharmacy.this,"Thêm Thành Công !",Toast.LENGTH_LONG).show();
                        alertDialog.cancel();

                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.cancel();
                    }
                });
                alertDialog.setCanceledOnTouchOutside(false);

                // show it
                alertDialog.show();
            }
        });
    }
    private void deletePhamar()
    {
        int allsize = dataList.size();
        for (int i = dataList.size()-1; i >= 0 ; i--)
        {
            if (dataList.get(i).isChon())
            {
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
            Toast.makeText(getApplicationContext(),"Vui lòng chọn nhà thuốc để xoá !",Toast.LENGTH_SHORT).show();
        }



    }
}