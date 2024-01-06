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
public class BangDia extends SanPham {

    private double doDai;
    
    public BangDia(){
        
    }

    public BangDia(String tenSanPham, String moTaSanPham, String nhaSanXuat, double giaBan, int doDai) {
        super(tenSanPham, moTaSanPham, nhaSanXuat, giaBan);
        this.doDai = doDai;
    }

    @Override
    public void nhapSanPham() {
        super.nhapSanPham();
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap do dai: ");
        this.doDai = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void xuatSanPham() {
        super.xuatSanPham();
        System.out.printf("\n- Do dai: %.2f\n----------", this.doDai);
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
}
