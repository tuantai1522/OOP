package com.btt.baitaplon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TKKyHan6Thang extends TaiKhoan implements DaoHan {

    public TKKyHan6Thang(double soTienGui) {
        super("TKKyHan6Thang", CauHinh.LAI_SUAT_6_THANG, soTienGui);
        this.ngayGui = LocalDate.now();

    }

    // Dùng cho việc ghi File    
    public TKKyHan6Thang(double soTienGui, String ngayGui) {
        super("TKKyHan6Thang", CauHinh.LAI_SUAT_6_THANG, soTienGui);
        this.ngayGui = LocalDate.parse(ngayGui, DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));

    }

    @Override
    public LocalDate tinhNgayDaoHan() {
        return this.ngayGui.plusMonths(6);
    }

}
