/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau3;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class SanPham {

    private static int dem = 0;
    private int maSanPham;
    private String tenSanPham;
    private String moTaSanPham;
    private String nhaSanXuat;
    private double giaBan;

    {
        dem++;
        setMaSanPham(dem);
    }
    
    public SanPham(){
        
    }
    public SanPham(String tenSanPham, String moTaSanPham, String nhaSanXuat, double giaBan) {
        this.tenSanPham = tenSanPham;
        this.moTaSanPham = moTaSanPham;
        this.nhaSanXuat = nhaSanXuat;
        this.giaBan = giaBan;
    }

    /**
     * @return the maSanPham
     */
    public int getMaSanPham() {
        return maSanPham;
    }

    /**
     * @param maSanPham the maSanPham to set
     */
    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
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
     * @return the moTaSanPham
     */
    public String getMoTaSanPham() {
        return moTaSanPham;
    }

    /**
     * @param moTaSanPham the moTaSanPham to set
     */
    public void setMoTaSanPham(String moTaSanPham) {
        this.moTaSanPham = moTaSanPham;
    }

    /**
     * @return the nhaSanXuat
     */
    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    /**
     * @param nhaSanXuat the nhaSanXuat to set
     */
    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    /**
     * @return the giaBan
     */
    public double getGiaBan() {
        return giaBan;
    }

    /**
     * @param giaBan the giaBan to set
     */
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void nhapSanPham() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten san pham: ");
        this.tenSanPham = sc.nextLine();

        System.out.print("Nhap mo ta san pham: ");
        this.moTaSanPham = sc.nextLine();

        System.out.print("Nhap nha san xuat: ");
        this.nhaSanXuat = sc.nextLine();

        System.out.print("Nhap gia ban: ");
        this.giaBan = Double.parseDouble(sc.nextLine());
    }
    
    public void xuatSanPham(){
        System.out.printf("\n- Ma SP: %d\n- Ten SP: %s\n- Gia SP: %.2f", this.maSanPham, this.tenSanPham, this.giaBan);
    }

}
