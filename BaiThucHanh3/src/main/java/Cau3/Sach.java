/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btt.bai3;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Sach extends SanPham {

    private int soTrang;

    public Sach() {
    }
    

    public Sach(String tenSanPham, double giaSanPham, int soTrang) {
        super(tenSanPham, giaSanPham);
        this.soTrang = soTrang;
    }

    /**
     * @return the soTrang
     */
    public int getSoTrang() {
        return soTrang;
    }

    /**
     * @param soTrang the soTrang to set
     */
    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap so trang san pham: ");
        this.soTrang = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" - %d", this.soTrang);
    }
}
