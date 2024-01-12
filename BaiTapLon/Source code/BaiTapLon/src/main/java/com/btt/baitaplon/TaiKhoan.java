/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btt.baitaplon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author HP
 */
public abstract class TaiKhoan implements DaoHan {

    private static int dem = 1;

    protected int maTaiKhoan;
    protected String ten;
    protected double laiSuat;
    protected double soTienGui;
    protected LocalDate ngayGui;

    {
        this.maTaiKhoan = dem++;
    }

    // Dùng cho việc ghi file
    public TaiKhoan(int maTaiKhoan, String ten, double laiSuat, double soTienGui) {
        this.maTaiKhoan = maTaiKhoan;
        this.ten = ten;
        this.laiSuat = laiSuat;
        this.soTienGui = soTienGui;
    }

    public TaiKhoan(String ten, double laiSuat, double soTienGui) {
        this.ten = ten;
        this.laiSuat = laiSuat;
        this.soTienGui = soTienGui;
    }

    @Override
    public String toString() {
        return String.format("\n%d - %s - %.3f - %.1f%% - %s",
                this.maTaiKhoan,
                this.ten,
                this.soTienGui,
                this.laiSuat * 100,
                this.ngayGui.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
    }

    public int getMaTaiKhoan() {
        return this.maTaiKhoan;
    }

    public String getTen() {
        return this.ten;
    }

    public double getSoTienGui() {
        return this.soTienGui;
    }

    public LocalDate getNgayGui() {
        return this.ngayGui;
    }

    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    public double tinhTienLai() {
        long soNgayGui = this.ngayGui.until(LocalDate.now(), ChronoUnit.DAYS);
        double laiSuatNgay = this.laiSuat / 365.0;

        return this.soTienGui * laiSuatNgay * soNgayGui;
    }

    @Override
    public boolean isDaoHan() {
        return LocalDate.now().equals(this.tinhNgayDaoHan()) || LocalDate.now().isAfter(this.tinhNgayDaoHan());
    }

    @Override
    public abstract LocalDate tinhNgayDaoHan();

    public boolean rutTien(double money) {
        if (money >= 0 && money <= this.soTienGui) {
            this.soTienGui -= money;
            return true;
        }
        return false;
    }

    public boolean guiTien(double money) {
        if (money >= 0) {
            this.soTienGui += money;
            return true;
        }
        return false;
    }
}
