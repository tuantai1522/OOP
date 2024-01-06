/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau1And2;

/**
 *
 * @author HP
 */
public abstract class Hinh {

    abstract double tinhDienTich();

    abstract double tinhChuVi();
    
    abstract String getTenHinh();

    public void hienThi() {
        System.out.printf("%s - %.2f - %.2f\n", this.getTenHinh(), this.tinhChuVi(), this.tinhDienTich());

    }
}
