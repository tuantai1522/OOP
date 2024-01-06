package com.btt.baitaplon;

public class TaiKhoanDangNhap {

    private String userName;

    private String passWord;

    public TaiKhoanDangNhap(String userName) {
        this.userName = userName;
        this.passWord = String.format("%06d", CauHinh.random.nextInt(999999) + 1);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.userName, this.passWord);
    }

    public boolean isDangNhapHopLe(String userName, String passWord) {
        return this.userName.equals(userName) && this.passWord.equals(passWord);
    }

}
