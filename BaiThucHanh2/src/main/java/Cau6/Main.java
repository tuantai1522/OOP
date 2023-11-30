/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau6;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) {
        PhanSo p1 = new PhanSo(1, 2);
        PhanSo p2 = new PhanSo(8, 5);

        PhanSo p3 = new PhanSo(13, 20);
        PhanSo p4 = new PhanSo(48, 15);

        DsPhanSo arr = new DsPhanSo();
        arr.themPhanSo(p1, p2, p3, p4);
        
        arr.themPhanSo();
        
        arr.hienThiDanhSach();

        PhanSo tong = arr.tinhTongCacPhanSo();
        System.out.printf("\nTong = ");
        tong.hienThi();

        PhanSo max = arr.timMax();
        System.out.printf("\nMax = ");
        max.hienThi();

        PhanSo min = arr.timMin();
        System.out.printf("\nMin = ");
        min.hienThi();
        
        System.out.printf("\nSap xep tang dan = ");
        arr.sapXepTangDan();
        arr.hienThiDanhSach();
        
        System.out.printf("\nSap xep giam dan = ");
        arr.sapXepGiamDan();
        arr.hienThiDanhSach();


    }
}
