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
public class SanPham {

    private static int dem = 0;
    private int id = ++dem;
    private String tenSanPham;
    private double giaSanPham;

    public SanPham() {
    }

    
    public SanPham(String tenSanPham, double giaSanPham) {
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
    }

    
    /**
     * @return the dem
     */
    public static int getDem() {
        return dem;
    }

    /**
     * @param aDem the dem to set
     */
    public static void setDem(int aDem) {
        dem = aDem;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tenSanPham
     */
    public String getTenSanPham() {
        return tenSanPham;
    }

    /**
     * @param tenSanPham the tenSanPham to set
     */
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    /**
     * @return the giaSanPham
     */
    public double getGiaSanPham() {
        return giaSanPham;
    }

    /**
     * @param giaSanPham the giaSanPham to set
     */
    public void setGiaSanPham(double giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ten san pham: ");
        this.tenSanPham = sc.nextLine();
        System.out.print("\nNhap gia san pham: ");
        this.giaSanPham = Double.parseDouble(sc.nextLine());
    }

    public void xuat() {
        System.out.printf("\n %d - %s - %.2f", this.id, this.tenSanPham, this.giaSanPham);
    }
}
