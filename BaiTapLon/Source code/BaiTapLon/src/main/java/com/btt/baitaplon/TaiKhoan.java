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
public abstract class TaiKhoan {

    protected String ten;
    protected double laiSuat;
    protected double soTienGui;
    protected LocalDate ngayGui;

    public TaiKhoan(String ten, double laiSuat, double soTienGui) {
        this.ten = ten;
        this.laiSuat = laiSuat;
        this.soTienGui = soTienGui;
    }

    @Override
    public String toString() {
        return String.format("\n%s - %.3f - %.1f%% - %s",
                this.ten,
                this.soTienGui,
                this.laiSuat * 100,
                this.ngayGui.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
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

    public double tinhTienLai() {
        long soNgayGui = this.ngayGui.until(LocalDate.now(), ChronoUnit.DAYS);
        double laiSuatNgay = this.laiSuat / 365.0;

        return this.soTienGui * laiSuatNgay * soNgayGui;
    }
}
