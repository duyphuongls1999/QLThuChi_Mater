package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
        EditText editTextnoidung,editTextloai;
        Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editTextloai = (EditText)findViewById(R.id.txtLoai);
        editTextnoidung=(EditText)findViewById(R.id.txtLoaithuChi);
        btnOk=(Button)findViewById(R.id.btnOK);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noidung=editTextnoidung.getText().toString();
                String loai=editTextloai.getText().toString();
                    LoaiChi loaiThuChi=new LoaiChi(noidung,loai);
                    DataManager dataManager = new DataManager(MainActivity3.this);
                    dataManager.addLoai(loaiThuChi);
                    Toast.makeText(MainActivity3.this,"add thanh cong",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
                    startActivity(intent);
                    setResult(3);

            }
        });
    }
}