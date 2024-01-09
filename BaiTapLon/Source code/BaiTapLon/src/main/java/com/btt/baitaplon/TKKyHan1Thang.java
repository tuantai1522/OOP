package com.btt.baitaplon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TKKyHan1Thang extends TaiKhoan implements DaoHan {

    public TKKyHan1Thang(double soTienGui) {
        super("TKKyHan1Thang", CauHinh.LAI_SUAT_1_THANG, soTienGui);
        this.ngayGui = LocalDate.now();

    }
    
    // Dùng cho việc ghi File    
    public TKKyHan1Thang(double soTienGui, String ngayGui) {
        super("TKKyHan1Thang", CauHinh.LAI_SUAT_1_THANG, soTienGui);
        this.ngayGui = LocalDate.parse(ngayGui, DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));

    }

    @Override
    public LocalDate tinhNgayDaoHan() {
        return this.ngayGui.plusMonths(1);
    }

}
