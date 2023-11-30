/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau1;

import Cau1.Class.Diem;

/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        Diem d1 = new Diem();
        Diem d2 = new Diem(3, 4);
        d1.hienThi();
        d2.hienThi();
        double tinhKhoangCach = d1.tinhKhoangCach(d2);
        System.out.printf("d = %.2f", tinhKhoangCach);

    }
}
