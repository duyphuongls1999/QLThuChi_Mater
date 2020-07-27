package com.example.testdatabase;

public class LoaiChi {
    private int id;
    private String noidung;
    private String loai;

    public LoaiChi(int id, String noidung, String loai) {
        this.id = id;
        this.noidung = noidung;
        this.loai = loai;
    }

    public LoaiChi(String noidung, String loai) {
        this.noidung = noidung;
        this.loai = loai;
    }

    public LoaiChi() {
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

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    @Override
    public String toString() {
        return noidung;
    }
}
