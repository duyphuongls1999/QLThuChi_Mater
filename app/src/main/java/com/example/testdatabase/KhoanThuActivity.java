package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class KhoanThuActivity extends AppCompatActivity {
    private EditText editSoTien, editGhiChu,editThoiGian,editLoaiThu;
    private Button btnChonNgay,btnHuy,btnLuu;
    private Spinner spinnerLoaiThu;
    private List<String> loaiThuList;
    private ArrayAdapter<String> loaiThuAdapter;
    private ListView listView;
    private List<LoaiThuChi> khoanThuList;
    ArrayAdapter adapter;
    DataManager dbThuChi;
    //  SQLiteDatabase db;
    private ImageView imageView;
    private String loaiThu[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoan_thu);
        anhxa();
        dbThuChi=new DataManager(this);
        loaiThuList = new ArrayList<String>();
        loaiThuList=dbThuChi.getAllNoidung();

//        loaiThuList.add("Tiền lương");
//        loaiThuList.add("Tiền thưởng");
//        loaiThuList.add("Tiền lãi");
//        loaiThuList.add("Được tặng");
//        loaiThuList.add("Bán đồ");
//        loaiThuList.add("Khoản thu khác");
        loaiThuAdapter = new ArrayAdapter(KhoanThuActivity.this,android.R.layout.simple_spinner_item,loaiThuList);
        loaiThuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLoaiThu.setAdapter(loaiThuAdapter);
        spinnerLoaiThu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editLoaiThu.setText(loaiThuList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dbThuChi = new DataManager(KhoanThuActivity.this);
        khoanThuList = dbThuChi.getAllKhoanThu();
        adapter = new ArrayAdapter<LoaiThuChi>(KhoanThuActivity.this,android.R.layout.simple_list_item_1,khoanThuList);
        khoanThuList.clear();
        listView.setAdapter(adapter);
        setAdapter();

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String loaiThu = editLoaiThu.getText().toString();
                String ghiChu = editGhiChu.getText().toString();
                String ngayTao = editThoiGian.getText().toString();
                int soTien =Integer.parseInt(editSoTien.getText().toString());
//                if(soTien == 0 || loaiThu.equals("") || ghiChu.equals("") || ngayTao.equals(""))
//                {
//                    Toast.makeText(KhoanThu.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
//                }
//                else {
                LoaiThuChi khoanThu = new LoaiThuChi(loaiThu, ghiChu, ngayTao, soTien, 1);
                dbThuChi.addKhoanThu(khoanThu);
                Toast.makeText(KhoanThuActivity.this, "Thêm khoản thu thành công", Toast.LENGTH_SHORT).show();
//                }

            }
        });

//                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//               LoaiThuChi kt =  khoanThuList.get(position);
//               int kq= dbThuChi.XoaKhoanThu(kt.getId());
//               if(kq>0) {
//                   Toast.makeText(KhoanThuActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
//               }
//               else {
//                   Toast.makeText(KhoanThuActivity.this, "Xóa không thành công", Toast.LENGTH_SHORT).show();
//               }
//               adapter.notifyDataSetChanged();
//                return false;
//            }
//        });

        btnChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonngay();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//               KhoanThuContact kt =  khoanThuList.get(position);
//               int kq= dbThuChi.XoaKhoanThu(kt.getMaLS());
//               if(kq>0) {
//                   Toast.makeText(KhoanThu.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
//               }
//               else {
//                   Toast.makeText(KhoanThu.this, "Xóa không thành công", Toast.LENGTH_SHORT).show();
//               }
//               adapter.notifyDataSetChanged();
//                return false;
//            }
//        });

    }

    public void chonngay()
    {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                editThoiGian.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }
    public void setAdapter()
    {
        khoanThuList.clear();
        khoanThuList.addAll(dbThuChi.getAllKhoanThu());
        adapter.notifyDataSetChanged();
    }

    public void anhxa() {
        btnChonNgay = (Button) findViewById(R.id.btnChonNgay);
        editSoTien = (EditText) findViewById(R.id.editSoTien);
        editGhiChu = (EditText) findViewById(R.id.editGhiChu);
        editThoiGian = (EditText)findViewById(R.id.editThoiGian);
        editLoaiThu =(EditText) findViewById(R.id.editLoaiThu);
        btnHuy = (Button)findViewById(R.id.btnHuy);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        spinnerLoaiThu = (Spinner) findViewById(R.id.spinnerLoaiThu);
        listView = (ListView) findViewById(R.id.listView);

    }
}