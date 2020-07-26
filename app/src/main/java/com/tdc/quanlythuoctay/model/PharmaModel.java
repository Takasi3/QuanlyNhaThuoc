package com.tdc.quanlythuoctay.model;

public class PharmaModel {
    private String MaNT;
    private String TenNT;
    private String DiaChi;
    private boolean chon;


    public PharmaModel() {

    }

    public String getMaNT() {
        return MaNT;
    }

    public void setMaNT(String maNT) {
        MaNT = "Mã : "+maNT;
    }

    public String getTenNT() {
        return TenNT;
    }

    public void setTenNT(String tenNT) {
        TenNT ="Tên : "+ tenNT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi ="Địa Chỉ : "+ diaChi;
    }

    public boolean isChon() {
        return chon;
    }

    public void setChon(boolean chon) {
        this.chon = chon;
    }
}
