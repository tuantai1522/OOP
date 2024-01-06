package com.btt.baitaplon;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NganHang {

    private List<KhachHang> DanhSachKhachHang = new ArrayList<>();

    public boolean isDangNhap() {
        return false;
    }

    public void layDanhSachKhachHang() throws Exception {
        File file = new File(CauHinh.KHACH_HANG_FILE_PATH);
        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNext()) {
                this.DanhSachKhachHang.add(taoKhachHangTuFile(sc.nextLine()));
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private KhachHang taoKhachHangTuFile(String data) throws ClassNotFoundException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String[] khInFo = data.split(" - ");

        // Tạo khách hàng từ các phần của chuỗi được cắt ra
        KhachHang kh = new KhachHang(
                khInFo[0], // Mã số tài khoản
                khInFo[1], // Họ tên
                khInFo[2], // Giới tính
                khInFo[3], // Ngày sinh
                khInFo[4], // Quê quán
                khInFo[5] // Số CCCD
        );

        // Thêm thông tin tài khoản vào danh sách tài khoản của khách hàng
        for (int i = 6; i < khInFo.length; i++) {
            String[] tkInfo = khInFo[i].split(",");

            String loaiTK = tkInfo[0];
            double soTienGui = Double.parseDouble(tkInfo[1]);
            String ngayGui = tkInfo[2];

            Class c = Class.forName(CauHinh.MAIN_FILE_PATH + loaiTK);
            // Tạo 1 constructor tương ứng với các tham số của class
            Constructor<?> constructor = c.getConstructor(double.class, String.class);

            TaiKhoan tk = (TaiKhoan) constructor.newInstance(soTienGui, ngayGui);

            kh.moTaiKhoan(tk);
        }

        return kh;
    }

    public void xuatDanhSachKhachHang() {
        this.DanhSachKhachHang.forEach(x -> System.out.print(x));
    }

    public void moTaiKhoanKhachHang(KhachHang kh) {
        this.DanhSachKhachHang.add(kh);

    }

    public List<TaiKhoan> traCuu(String maSo) {
        return null;
    }

    public void sapXep() {

    }

    /**
     * @return the DanhSachKhachHang
     */
    public List<KhachHang> getDanhSachKhachHang() {
        return DanhSachKhachHang;
    }

}
