package com.btt.baitaplon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TKKyHan1Tuan extends TaiKhoan implements DaoHan {

    public TKKyHan1Tuan(double soTienGui) {
        super("TKKyHan1Tuan", CauHinh.LAI_SUAT_1_TUAN, soTienGui);
        this.ngayGui = LocalDate.now();

    }

    // Dùng cho việc ghi File    
    public TKKyHan1Tuan(double soTienGui, String ngayGui) {
        super("TKKyHan1Tuan", CauHinh.LAI_SUAT_1_TUAN, soTienGui);
        this.ngayGui = LocalDate.parse(ngayGui, DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));

    }

    @Override
    public LocalDate tinhNgayDaoHan() {
        return this.ngayGui.plusWeeks(1);
    }

}
