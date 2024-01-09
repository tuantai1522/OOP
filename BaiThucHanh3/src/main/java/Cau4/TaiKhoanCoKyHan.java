/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btt.bai4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author admin
 */
public class TaiKhoanCoKyHan extends TaiKhoan {

    private LocalDate ngayDaoHan;
    private KyHan kyHan;

    public TaiKhoanCoKyHan(String tenTk, double soTien, KyHan kyHan) {
        super(tenTk, soTien);
        this.kyHan = kyHan;

        this.ngayDaoHan = kyHan.tinhKyHan(LocalDate.now());
    }

    /**
     * @return the ngayDaoHan
     */
    public LocalDate getNgayDaoHan() {
        return ngayDaoHan;
    }

    /**
     * @param ngayDaoHan the ngayDaoHan to set
     */
    public void setNgayDaoHan(LocalDate ngayDaoHan) {
        this.ngayDaoHan = ngayDaoHan;
    }

    /**
     * @return the kyHan
     */
    public KyHan getKyHan() {
        return kyHan;
    }

    /**
     * @param kyHan the kyHan to set
     */
    public void setKyHan(KyHan kyHan) {
        this.kyHan = kyHan;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", super.toString(), this.kyHan, this.ngayDaoHan.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    @Override
    public double tinhTienLai() {
        return kyHan.tinhTienLai(this.soTien);
    }

    @Override
    public boolean isDaoHan() {
        return this.ngayDaoHan.equals(LocalDate.now());
    }
}
