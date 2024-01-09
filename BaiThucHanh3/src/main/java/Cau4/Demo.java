/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btt.bai4;

/**
 *
 * @author admin
 */
public class Demo {

    public static void main(String[] args) {
        TaiKhoan t1 = new TaiKhoan("Nguyen Van A", 5000);
        TaiKhoan t2 = new TaiKhoanCoKyHan("Nguyen Van B", 15000, KyHan.MOT_TUAN);
        TaiKhoan t3 = new TaiKhoanCoKyHan("Nguyen Van C", 10000, KyHan.MOT_THANG);

        System.out.print(t1);

        System.out.print(t2);

        System.out.print(t3);

    }
}
