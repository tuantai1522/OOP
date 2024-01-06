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
public class Sach extends SanPham {

    private int soTrang;

    public Sach() {

    }

    public Sach(String tenSanPham, String moTaSanPham, String nhaSanXuat, double giaBan, int soTrang) {
        super(tenSanPham, moTaSanPham, nhaSanXuat, giaBan);
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
    public void nhapSanPham() {
        super.nhapSanPham();
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so trang: ");
        this.soTrang = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void xuatSanPham() {
        super.xuatSanPham();
        System.out.printf("\n- So trang: %d\n----------", this.soTrang);
    }
}
