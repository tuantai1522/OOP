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
public class BangDia extends SanPham {

    private double doDai;

    public BangDia() {
    }
    

    public BangDia(String tenSanPham, double giaSanPham, double doDai) {
        super(tenSanPham, giaSanPham);
        this.doDai = doDai;
    }

    /**
     * @return the doDai
     */
    public double getDoDai() {
        return doDai;
    }

    /**
     * @param doDai the doDai to set
     */
    public void setDoDai(double doDai) {
        this.doDai = doDai;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap do dai san pham: ");
        this.doDai = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" - %.2f", this.doDai);
    }
}
