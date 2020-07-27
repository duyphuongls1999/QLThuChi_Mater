package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrangChu extends AppCompatActivity {
    TextView txtTongThu, txtTongChi, txtSoDu;
    Button btnKhoanThu, btnKhoanChi, btnKhoanChiHangThang, btnThongKe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        AnhXa();
        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChu.this,LichSuThuChiMainActivity.class);
                startActivity(intent);

            }
        });
        btnKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChu.this,ActivityKhoanChi.class);
                startActivity(intent);
            }
        });
        btnKhoanThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChu.this,KhoanThuActivity.class);
                startActivity(intent);

            }
        });
    }
    public void AnhXa(){
        txtTongThu = (TextView) findViewById(R.id.txtTongThu);
        txtTongChi = (TextView) findViewById(R.id.txtTongChi);
        txtSoDu = (TextView) findViewById(R.id.txtSoDu);

        btnKhoanThu = (Button) findViewById(R.id.btnKhoanThu);
        btnKhoanChi = (Button) findViewById(R.id.btnKhoanChi);
        btnKhoanChiHangThang = (Button) findViewById(R.id.btnKhoanChiHangThang);
        btnThongKe = (Button) findViewById(R.id.btnThongKe);

    }

}