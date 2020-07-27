package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LichSuThuChiMainActivity extends AppCompatActivity {

    private DataManager dbThuChi;

    ListView lvThongKe;
    TextView txtTieuDe;
    LinearLayout layout;
    //ThongKeAdapter adapter;
    ArrayAdapter<LoaiThuChi> adapter1;
    List<LoaiThuChi> keList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_thu_chi_main);
        AnhXa();
        //do du lieu ra list view
        dbThuChi = new DataManager(LichSuThuChiMainActivity.this);
        keList = new ArrayList<>();
        keList = dbThuChi.layDanhSachLichSu();


        adapter1 = new ArrayAdapter<>(LichSuThuChiMainActivity.this, android.R.layout.simple_list_item_1,keList);
        //adapter = new ThongKeAdapter(MainActivity.this, list_item,keList);

        adapter1.notifyDataSetChanged();
        lvThongKe.setAdapter(adapter1);
    }
    public  void AnhXa(){
        lvThongKe = (ListView) findViewById(R.id.listViewhienthithongke);
        txtTieuDe = (TextView) findViewById(R.id.textTieuDe);
        layout = (LinearLayout) findViewById(R.id.activity);
        //dbThuChi = new DbThuChi(this,"thuchi.db","null",3);
    }
}