package com.example.testdatabase;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class DataManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "thuchi.db";
    private static final String TABLE_LICHSU = "LICHSUTHUCHI";
    private static final String COLUMN_LICHSU_MaLS = "MaLichSu";
    private static final String COLUMN_LICHSU_NoiDung = "NoiDung";
    private static final String COLUMN_LICHSU_GhiChu = "GhiChu";
    private static final String COLUMN_LICHSU_NgayTao = "NgayTao";
    private static final String COLUMN_LICHSU_SoTien = "SoTien";
    private static final String COLUMN_LICHSU_Loai = "Loai";
    private static final String TABLE_LOAITHUCHI = "LOAITHUCHI";
    private static final String COLUMN_LOAITHUCHI_MaLoaiThuChi = "MaLoaiThuChi";
    private static final String COLUMN_LOAITHUCHI_NoiDung = "NoiDung";
    private static final String COLUMN_LOAITHUCHI_Loai = "Loai";

    private Context context1;

    public DataManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context1 = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlLichSu = "CREATE TABLE " + TABLE_LICHSU + " ( " +
                COLUMN_LICHSU_MaLS + " integer primary key , " +
                COLUMN_LICHSU_NoiDung + " TEXT, " +
                COLUMN_LICHSU_GhiChu + " TEXT, " +
                COLUMN_LICHSU_NgayTao + " TEXT," +
                COLUMN_LICHSU_SoTien + " TEXT, " +
                COLUMN_LICHSU_Loai + " TEXT)";
        String sqlLoaiThuChi = "CREATE TABLE " + TABLE_LOAITHUCHI + " (" +
                COLUMN_LOAITHUCHI_MaLoaiThuChi + " integer primary key, " +
                COLUMN_LOAITHUCHI_NoiDung + " TEXT, " +
                COLUMN_LOAITHUCHI_Loai + " TEXT)";
        db.execSQL(sqlLichSu);
        db.execSQL(sqlLoaiThuChi);
        Log.e("Tao database thanh cong","success");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
//   public void addLoai(LoaiThuChi loaiThuChi) {
//       SQLiteDatabase db = this.getWritableDatabase();
//       ContentValues values = new ContentValues();
//       values.put(COLUMN_LOAITHUCHI_NoiDung, loaiThuChi.getNoidung());
//       values.put(COLUMN_LOAITHUCHI_Loai, loaiThuChi.getLoai());
//       db.insert(TABLE_LOAITHUCHI, null, values);
//       db.close();
//   }


   public List<LoaiChi> layDanhSachLoaiThuChi(){
        List<LoaiChi> listLichSu = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String sqlSelect = "SELECT  * FROM " + TABLE_LOAITHUCHI;
        Cursor cursor = db.rawQuery(sqlSelect, null);
        if (cursor.moveToFirst())
       {
           do {
               LoaiChi loiNhac = new LoaiChi();
               loiNhac.setId(cursor.getInt(0));
               loiNhac.setNoidung(cursor.getString(1));
               loiNhac.setLoai(cursor.getString(2));
               listLichSu.add(loiNhac);
           }
           while (cursor.moveToNext()) ;
       }
        cursor.close();
        db.close();
        return listLichSu;
    }
//    public int XoaKhoanThu(int id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_LICHSU,COLUMN_LICHSU_MaLS+"=?",new String[] {String.valueOf(id)});
//    }
    public void addLoai(LoaiChi loaiThuChi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LOAITHUCHI_NoiDung, loaiThuChi.getNoidung());
        values.put(COLUMN_LOAITHUCHI_Loai, loaiThuChi.getLoai());
        db.insert(TABLE_LOAITHUCHI,null,values);
        db.close();
    }
    public void addKhoanChi(LoaiThuChi loaiThuChi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LICHSU_NoiDung, loaiThuChi.getNoidung());
        values.put(COLUMN_LICHSU_GhiChu, loaiThuChi.getGhichu());
        values.put(COLUMN_LICHSU_NgayTao, loaiThuChi.getNgaytao());
        values.put(COLUMN_LICHSU_SoTien, loaiThuChi.getSotien());
        values.put(COLUMN_LICHSU_Loai, 0);
        db.insert(TABLE_LICHSU,null,values);
        db.close();
    }
    public void addKhoanThu(LoaiThuChi loaiThuChi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LICHSU_NoiDung, loaiThuChi.getNoidung());
        values.put(COLUMN_LICHSU_GhiChu, loaiThuChi.getGhichu());
        values.put(COLUMN_LICHSU_NgayTao, loaiThuChi.getNgaytao());
        values.put(COLUMN_LICHSU_SoTien, loaiThuChi.getSotien());
        values.put(COLUMN_LICHSU_Loai, 1);
        db.insert(TABLE_LICHSU,null,values);
        db.close();
    }
    public List<LoaiThuChi> layDanhSachLichSu(){
        List<LoaiThuChi> listLichSu = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String sqlSelect = "SELECT * FROM LICHSUTHUCHI";
        Cursor cursor = db.rawQuery(sqlSelect, null);
        if (cursor.moveToNext()){
            do{
                LoaiThuChi thongKe = new LoaiThuChi();
                thongKe.setId(cursor.getInt(0));
                thongKe.setNoidung(cursor.getString(1));
                thongKe.setGhichu(cursor.getString(2));
                thongKe.setNgaytao(cursor.getString(3));
                thongKe.setLoai(Integer.valueOf(cursor.getInt(5)));
                thongKe.setSotien(cursor.getInt(4));
                listLichSu.add(thongKe);
            }
            while (cursor.moveToNext());


        }
        cursor.close();
        return listLichSu;
    }

    public List<LoaiThuChi> getAllKhoanThu() {
        List<LoaiThuChi> khoanThuList = new ArrayList<LoaiThuChi>();
        String selectQuery = "SELECT  * FROM " + TABLE_LICHSU;
        khoanThuList.clear();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        while (cursor.moveToNext())
        {
            LoaiThuChi khoanThu = new LoaiThuChi();
            khoanThu.setId(cursor.getInt(0));
            khoanThu.setNoidung(cursor.getString(1));
            khoanThu.setGhichu(cursor.getString(2));
            khoanThu.setNgaytao(cursor.getString(3));
            khoanThu.setSotien(cursor.getInt(4));
            khoanThu.setLoai(cursor.getInt(5));
            khoanThuList.add(khoanThu);

        }
        cursor.close();
        db.close();
        return khoanThuList;
    }
    public List<String> getAllNoidung() {
        List<String> noiDungList = new ArrayList<String>();
        String selectQuery = "SELECT  * FROM " + TABLE_LOAITHUCHI;
        noiDungList.clear();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        while (cursor.moveToNext())
        {
            String noidung = cursor.getString(1);
            noiDungList.add(noidung);

        }
        cursor.close();
        db.close();
        return noiDungList;
    }

//    public List<LichSu> layNoiDung(){
//        List<LichSu> lichSuList = new ArrayList<LichSu>();
//        String sqlSelect = "SELECT NoiDung FROM LoaiThuChiHangNgay";
//        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery(sqlSelect,null);
//        if(cursor.moveToFirst()){
//            do {
//                LichSu lichSu = new LichSu();
//                lichSu.setNoiDung(cursor.getString(0));
//                lichSuList.add(lichSu);
//            }
//            while (cursor.moveToNext());
//        }
//        return lichSuList;
//    }*/


}


