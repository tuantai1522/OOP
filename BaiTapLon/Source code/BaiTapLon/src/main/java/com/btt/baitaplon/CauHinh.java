/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btt.baitaplon;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class CauHinh {

    public static final Scanner sc = new Scanner(System.in);

    public static final double LAI_SUAT_KHONG_KY_HAN = 0.002;

    public static final double LAI_SUAT_1_TUAN = 0.02;
    public static final double LAI_SUAT_1_THANG = 0.055;
    public static final double LAI_SUAT_6_THANG = 0.075;
    public static final double LAI_SUAT_12_THANG = 0.079;

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public static final Random random = new Random();

    public static final String TAI_KHOAN_FILE_PATH = "src/main/resources/TaiKhoan.txt";
    public static final String KHACH_HANG_FILE_PATH = "src/main/resources/KhachHang.txt";
    public static final String TAI_KHOAN_DANG_NHAP_FILE_PATH = "src/main/resources/TaiKhoanDangNhap.txt";
    public static final String MAIN_FILE_PATH = "com.btt.baitaplon.";

    //Khởi tạo dùng để mở tài khoản cho KhachHang
    public static final Map<Integer, String> mapToCreateTaiKhoan;

    static {
        mapToCreateTaiKhoan = new HashMap<>();
        mapToCreateTaiKhoan.put(1, "TKKyHan1Tuan");
        mapToCreateTaiKhoan.put(2, "TKKyHan1Thang");
        mapToCreateTaiKhoan.put(3, "TKKyHan6Thang");
        mapToCreateTaiKhoan.put(4, "TKKyHan12Thang");

    }

}
