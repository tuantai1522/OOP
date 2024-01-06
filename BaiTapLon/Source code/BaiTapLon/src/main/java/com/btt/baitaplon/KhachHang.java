/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btt.baitaplon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class KhachHang {

    private static int dem = 1;

    private String gioiTinh;

    private LocalDate ngaySinh;

    private String queQuan;

    private String soCCCD;

    private String maSoTaiKhoan;

    private String hoTen;

    private List<TaiKhoan> DanhSachTaiKhoan = new ArrayList<>();

    public KhachHang() {

    }

    public KhachHang(String maSoTaiKhoan, String hoTen, String gioiTinh, String ngaySinh, String queQuan, String soCCCD) {
        this.maSoTaiKhoan = maSoTaiKhoan;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));
        this.queQuan = queQuan;
        this.soCCCD = soCCCD;
    }

    public KhachHang(String hoTen, String gioiTinh, String ngaySinh, String queQuan, String soCCCD) {
        this.maSoTaiKhoan = String.format("%02d%02d%02d%04d",
                LocalDate.now().getDayOfMonth(),
                LocalDate.now().getMonthValue(),
                LocalDate.now().getYear(),
                dem++);
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));
        this.queQuan = queQuan;
        this.soCCCD = soCCCD;
    }

    public void nhapKhachHang() {

    }
    
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("\n%s - %s - %s", this.maSoTaiKhoan, this.hoTen, this.gioiTinh));
        this.DanhSachTaiKhoan.forEach(x -> {
            res.append("\n\t+ ").append(x.toString());
        });
        
        return res.toString();
    }

    public void doiMatKhau() {

    }

    public double tinhTienLai() {
        return 0;
    }

    public void moTaiKhoan(TaiKhoan tk) {
        this.DanhSachTaiKhoan.add(tk);
    }

    public void guiTien(double money) {

    }

    public void rutTien(double money) {

    }

    public void xuatDanhSachTaiKhoan() {
        this.DanhSachTaiKhoan.forEach(x -> System.out.print(x));
    }

    public double tinhTongTienGui() {
        return 0;
    }

    public boolean isToiThieu50VND() {
        return false;
    }

    public String getMaSoTaiKhoan() {
        return this.maSoTaiKhoan;
    }

    public String getHoTen() {
        return null;
    }

    /**
     *
     * @return
     */
    public List<TaiKhoan> getDanhSachTaiKhoan() {
        return null;
    }
}
