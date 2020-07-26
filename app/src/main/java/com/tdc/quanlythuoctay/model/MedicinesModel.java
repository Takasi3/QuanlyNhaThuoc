package com.tdc.quanlythuoctay.model;

public class MedicinesModel {
    private String maThuoc;
    private String tenThuoc;
    private String donGia;
    private String donVi;
    private boolean chon;

    public MedicinesModel(String maThuoc, String tenThuoc, String donGia, String donVi, boolean chon) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.donGia = donGia;
        this.donVi = donVi;
        this.chon = chon;
    }

    public MedicinesModel() {

    }

    public String getMaThuoc() {
        return "Mã : "+ maThuoc;
    }

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }

    public String getTenThuoc() {
        return "Tên : "+ tenThuoc;
    }


    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getDonGia() {
        return "Giá : " + donGia +"VND";
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getDonVi() {
        return "Đơn vị : " +donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }


    public boolean isChon() {
        return chon;
    }

    public void setChon(boolean chon) {
        this.chon = chon;
    }
}
