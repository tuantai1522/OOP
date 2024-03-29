package com.btt.baitaplon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaiKhoanKhongKyHan extends TaiKhoan {

    public TaiKhoanKhongKyHan(double soTienGui) {
        super("TaiKhoanKhongKyHan", CauHinh.LAI_SUAT_KHONG_KY_HAN, soTienGui);
        this.ngayGui = LocalDate.now();
    }

    // Dùng cho việc ghi File    
    public TaiKhoanKhongKyHan(int maTaiKhoan, double soTienGui, String ngayGui) {
        super(maTaiKhoan, "TaiKhoanKhongKyHan", CauHinh.LAI_SUAT_KHONG_KY_HAN, soTienGui);
        this.ngayGui = LocalDate.parse(ngayGui, DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));
    }

    @Override
    public LocalDate tinhNgayDaoHan() {
        return LocalDate.now();
    }
    
    

}
