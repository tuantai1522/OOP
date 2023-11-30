/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau5;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) {
        PhanSo p1 = new PhanSo(1, 2);
        PhanSo p2 = new PhanSo(3, 10);
        PhanSo temp = p1.chiaPhanSo(p2);
//        int soSanh = p2.soSanh(p1);
//        System.out.printf("Ket qua: %d", soSanh);
//        temp.hienThi();

        ListPhanSo arr = new ListPhanSo();
        arr.themPhanSo();
        arr.themPhanSo(p1);
        arr.themPhanSo(p2, temp);
        
      
        arr.hienThiDanhSachPhanSo();
       
        PhanSo total = arr.tinhTongCacPhanSo();
        System.out.print("\nTong cac phan so: ");
        total.hienThi();
        
        PhanSo max = arr.timMaxPhanSo();
        System.out.print("\nPhan so lon nhat: ");
        max.hienThi();
    }
}
