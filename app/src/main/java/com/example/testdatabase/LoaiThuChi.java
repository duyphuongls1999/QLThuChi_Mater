package com.example.testdatabase;

import java.io.Serializable;

public class LoaiThuChi implements Serializable {
    private int id;
    private String noidung;
    private String ghichu;
    private String ngaytao;
    private int sotien;
    private int loai;

    public LoaiThuChi(int id, String noidung, String ghichu, String ngaytao, int sotien, int loai) {
        this.id = id;
        this.noidung = noidung;
        this.ghichu = ghichu;
        this.ngaytao = ngaytao;
        this.sotien = sotien;
        this.loai = loai;
    }

    public LoaiThuChi(String noidung, String ghichu, String ngaytao, int sotien, int loai) {
        this.noidung = noidung;
        this.ghichu = ghichu;
        this.ngaytao = ngaytao;
        this.sotien = sotien;
        this.loai = loai;
    }

    public LoaiThuChi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getSotien() {
        return sotien;
    }

    public void setSotien(int sotien) {
        this.sotien = sotien;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }


    @Override
    public String toString() {
        return "Nội dung :" +noidung + " -" +"   Ghi chú :" + ghichu+ " -" +"  Ngày tạo :" +ngaytao +" -"+"  Số tiền :"+sotien;
    }
}
