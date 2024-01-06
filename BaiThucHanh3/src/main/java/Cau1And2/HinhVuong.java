/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau1And2;

/**
 *
 * @author HP
 */
public class HinhVuong extends HinhChuNhat {

    public HinhVuong(double canh) {
        super(canh, canh);
    }

    @Override
    public String getTenHinh() {
        return "Hinh vuong";
    }
}
