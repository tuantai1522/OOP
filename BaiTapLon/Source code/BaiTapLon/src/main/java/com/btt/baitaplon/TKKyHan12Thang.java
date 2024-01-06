package com.btt.baitaplon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TKKyHan12Thang extends TaiKhoan implements DaoHan {

    public TKKyHan12Thang(double soTienGui) {
        super("TKKyHan12Thang", CauHinh.LAI_SUAT_12_THANG, soTienGui);
        this.ngayGui = LocalDate.now();
    }

    public TKKyHan12Thang(double soTienGui, String ngayGui) {
        super("TKKyHan12Thang", CauHinh.LAI_SUAT_12_THANG, soTienGui);
        this.ngayGui = LocalDate.parse(ngayGui, DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT));

    }

    @Override
    public LocalDate tinhNgayDaoHan() {
        return this.ngayGui.plusYears(1);
    }

}
