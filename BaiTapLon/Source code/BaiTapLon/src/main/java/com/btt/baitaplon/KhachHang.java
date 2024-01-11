/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btt.baitaplon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    {
        this.maSoTaiKhoan = String.format("%02d%02d%02d%04d",
                LocalDate.now().getDayOfMonth(),
                LocalDate.now().getMonthValue(),
                LocalDate.now().getYear(),
                dem++);
    }

    // Dùng cho việc ghi File
    public KhachHang(String maSoTaiKhoan, String hoTen, String gioiTinh, String ngaySinh, String queQuan, String soCCCD) {
        this.maSoTaiKhoan = maSoTaiKhoan;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));
        this.queQuan = queQuan;
        this.soCCCD = soCCCD;
    }

    public KhachHang(String hoTen, String gioiTinh, String ngaySinh, String queQuan, String soCCCD) {

        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = LocalDate.parse(ngaySinh, DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));
        this.queQuan = queQuan;
        this.soCCCD = soCCCD;
    }

    public void nhapKhachHang() {

        System.out.print("\nNhap ho ten: ");
        this.hoTen = CauHinh.sc.nextLine();
        System.out.print("\nNhap gioi tinh: ");
        this.gioiTinh = CauHinh.sc.nextLine();
        System.out.print(String.format("\nNhap ngay sinh (%s): ", CauHinh.DATE_FORMAT));
        this.ngaySinh = LocalDate.parse(CauHinh.sc.nextLine(), DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));
        System.out.print("\nNhap que quan: ");
        this.queQuan = CauHinh.sc.nextLine();
        System.out.print("\nNhap so CCCD: ");
        this.soCCCD = CauHinh.sc.nextLine();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("\n");
        res.append(String.format("\n%s - %s - %s", this.maSoTaiKhoan, this.hoTen, this.gioiTinh));
        this.DanhSachTaiKhoan.forEach(x -> {
            res.append(x.toString());
        });
        res.append(String.format("\n\t+ Tong tien gui: %.3f", this.tinhTongTienGui()));
        res.append(String.format("\n\t+ Tong tien lai: %.3f", this.tinhToanBoTienLai()));

        return res.toString();
    }

    public void moTaiKhoan(TaiKhoan tk) {
        this.DanhSachTaiKhoan.add(tk);
    }

    public void guiTienTaiKhoan(double money) {

    }

    public void rutTienTaiKhoan(double money) {

    }

    public void xuatDanhSachTaiKhoan() {
        this.DanhSachTaiKhoan.forEach(x -> System.out.print(x));
    }

    public double tinhTongTienGui() {
        return this.DanhSachTaiKhoan.stream().mapToDouble(TaiKhoan::getSoTienGui).sum();
    }

    public double tinhToanBoTienLai() {
        return this.DanhSachTaiKhoan.stream().mapToDouble(TaiKhoan::tinhTienLai).sum();
    }

    public KhachHang docFile(String data) throws ClassNotFoundException, ClassNotFoundException,
            NoSuchMethodException, InstantiationException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        String[] khachHangInFo = data.split(" - ");

        // Tạo khách hàng từ các phần của chuỗi được cắt ra
        this.setMaSoTaiKhoan(khachHangInFo[0]);
        this.setHoTen(khachHangInFo[1]);
        this.setGioiTinh(khachHangInFo[2]);
        this.setNgaySinh(LocalDate.parse(khachHangInFo[3], DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
        this.setQueQuan(khachHangInFo[4]);
        this.setSoCCCD(khachHangInFo[5]);

        // Thêm thông tin tài khoản vào danh sách tài khoản của khách hàng
        for (int i = 6; i < khachHangInFo.length; i++) {
            String[] tkInfo = khachHangInFo[i].split(",");

            String loaiTK = tkInfo[0];
            double soTienGui = Double.parseDouble(tkInfo[1]);
            String ngayGui = tkInfo[2];

            Class c = Class.forName(CauHinh.MAIN_FILE_PATH + loaiTK);
            // Tạo 1 constructor tương ứng với các tham số của class
            Constructor<?> constructor = c.getConstructor(double.class, String.class);

            TaiKhoan tk = (TaiKhoan) constructor.newInstance(soTienGui, ngayGui);

            this.getDanhSachTaiKhoan().add(tk);
        }

        return this;
    }

    public void ghiFile() throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CauHinh.KHACH_HANG_FILE_PATH, true))) {
            // Ghi dữ liệu vào tập tin

            try {

                //Thông tin khách hàng
                writer.write(String.format("%s - %s - %s - %s - %s - %s",
                        this.getMaSoTaiKhoan(),
                        this.getHoTen(),
                        this.getGioiTinh(),
                        this.getNgaySinh().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)),
                        this.getQueQuan(),
                        this.getSoCCCD()
                ));

                //Thông tin tài khoản của khách hàng
                this.getDanhSachTaiKhoan().forEach(tk -> {
                    try {
                        writer.write(String.format(" - %s,%.3f,%s",
                                tk.getTen(),
                                tk.getSoTienGui(),
                                tk.getNgayGui().format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT))
                        ));
                    } catch (IOException ex) {
                        Logger.getLogger(NganHang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                writer.write("\n");
            } catch (IOException ex) {
                Logger.getLogger(NganHang.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean isToiThieu50VND() {
        return false;
    }

    public String getMaSoTaiKhoan() {
        return this.maSoTaiKhoan;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public String getGioiTinh() {
        return this.gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return this.ngaySinh;
    }

    public String getQueQuan() {
        return this.queQuan;
    }

    public String getSoCCCD() {
        return this.soCCCD;
    }

    public List<TaiKhoan> getDanhSachTaiKhoan() {
        return this.DanhSachTaiKhoan;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setSoCCCD(String soCCCD) {
        this.soCCCD = soCCCD;
    }

    public void setMaSoTaiKhoan(String maSoTaiKhoan) {
        this.maSoTaiKhoan = maSoTaiKhoan;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDanhSachTaiKhoan(List<TaiKhoan> DanhSachTaiKhoan) {
        this.DanhSachTaiKhoan = DanhSachTaiKhoan;
    }

}
