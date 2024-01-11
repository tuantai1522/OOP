package com.btt.baitaplon;

import java.io.FileWriter;
import java.io.IOException;

public class TaiKhoanDangNhap {

    private String userName;
    private static int dem;
    private String passWord;

    public TaiKhoanDangNhap() {
    }

    
    public TaiKhoanDangNhap(String userName) {
        this.userName = userName;
        this.passWord = String.format("%06d", CauHinh.random.nextInt(999999) + 1);
    }

    public void ghiFile() throws Exception {
        // Viết dữ liệu vào file
        try (
                FileWriter fileWriter = new FileWriter(CauHinh.TAI_KHOAN_DANG_NHAP_FILE_PATH, true)) {
            // Viết dữ liệu vào file
            fileWriter.write(String.format("%s - %s\n", this.userName, this.passWord));
            // Đóng file
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public TaiKhoanDangNhap docFile(String data) {
        String[] taiKhoanDangNhapInfo = data.split(" - ");
        this.setUserName(taiKhoanDangNhapInfo[0]);
        this.setPassWord(taiKhoanDangNhapInfo[1]);
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return String.format("\n%s - %s", this.userName, this.passWord);
    }

    public boolean isHopLe(String userName, String passWord) {
        return this.userName.equals(userName) && this.passWord.equals(passWord);
    }

}
