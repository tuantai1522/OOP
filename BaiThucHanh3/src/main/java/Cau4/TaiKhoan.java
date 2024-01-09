/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btt.bai4;

/**
 *
 * @author admin
 */
public class TaiKhoan {

    private static int dem = 0;
    protected String soTk;
    protected String tenTk;
    protected double soTien;

    {
        ++dem;
        this.soTk = String.format("%06d", dem);
    }

    public TaiKhoan(String tenTk, double soTien) {
        this.tenTk = tenTk;
        this.soTien = soTien;
    }

    public boolean isDaoHan() {
        return true;
    }

    public void nopTien(double d) {
        if (this.isDaoHan()) {
            this.soTien += d;
        }
    }

    public void rutTien(double d) {
        if (this.isDaoHan() && this.soTien > d) {
            this.soTien += d;
        }
    }

    @Override
    public String toString() {
        return String.format("\n%s - %s - %.1f - %.2f", this.soTk, this.tenTk, this.soTien, this.tinhTienLai());
    }

    public String getSoTk() {
        return this.soTk;
    }

    public String getTenTk() {
        return this.tenTk;
    }

    public double tinhTienLai() {
        return this.soTien * 0.001 / 12;
    }
}
