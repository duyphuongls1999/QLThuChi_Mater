package com.example.testdatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    List<LoaiChi> loaiThuChiList;
    ArrayAdapter<LoaiChi> arrayAdapter;
    DataManager dataManager;
    ListView listView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn=(Button)findViewById(R.id.btnAdd);
        listView=(ListView)findViewById(R.id.list) ;
        dataManager = new DataManager(this);
        loaiThuChiList=dataManager.layDanhSachLoaiThuChi();
        arrayAdapter=new ArrayAdapter<LoaiChi>(MainActivity2.this,android.R.layout.simple_list_item_1,loaiThuChiList);
        listView.setAdapter(arrayAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivityForResult(intent,3);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LoaiChi ln = loaiThuChiList.get(position);
                Intent intent1 = new Intent();
                String noidung=ln.getNoidung();
                intent1.putExtra("noidung",noidung);
                setResult(2,intent1);
                finish();

            }
        });
    }
    public void capnhaplist()
    {
        loaiThuChiList.clear();
        loaiThuChiList=dataManager.layDanhSachLoaiThuChi();
        arrayAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode==3)
        {
            capnhaplist();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}