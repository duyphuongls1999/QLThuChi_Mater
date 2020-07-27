package com.example.testdatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ActivityKhoanChi extends AppCompatActivity {
    EditText editText,editTextngay,editTextghichu,editTextsotien;
    Button btnTHem,bntxoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoanchi);
        anhxa();
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityKhoanChi.this,MainActivity2.class);
                startActivityForResult(intent,1);
            }

        });
        btnTHem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noidung =editText.getText().toString();
                String ghichu =editTextghichu.getText().toString();
                String ngaytao =editTextngay.getText().toString();
                int sotien =Integer.parseInt(editTextsotien.getText().toString());
                LoaiThuChi loaiThuChi = new LoaiThuChi(noidung,ghichu,ngaytao,sotien,0);
                DataManager dataManager = new DataManager(ActivityKhoanChi.this);
                dataManager.addKhoanChi(loaiThuChi);
                Toast.makeText(ActivityKhoanChi.this,"Add khoản chi thành công",Toast.LENGTH_LONG).show();
            }
        });
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
            private void updateLabel() {
                String myFormat = "MM/dd/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                editTextngay.setText(sdf.format(myCalendar.getTime()));
            }
        };
        editTextngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ActivityKhoanChi.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==2){
            editText.setText(data.getStringExtra("noidung"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void anhxa()
    {
        editTextngay=(EditText)findViewById(R.id.edittextngaytao);
        editTextghichu=(EditText)findViewById(R.id.edittextghichu);
        editTextsotien=(EditText)findViewById(R.id.edittextsotien);
        editText=(EditText)findViewById(R.id.edittext);
        btnTHem=(Button)findViewById(R.id.btnThem);
        bntxoa=(Button)findViewById(R.id.btnHuy);

    }
}