/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau1And2;

/**
 *
 * @author HP
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        Hinh h2 = new Circle(65);
        Hinh h5 = new TamGiac(60, 65, 55);
        Hinh h3 = new HinhChuNhat(60, 65);
        Hinh h4 = new HinhVuong(60);
        Hinh h6 = new TamGiacCan(55, 60);
        Hinh h1 = new Ellipse(65, 55);
        Hinh h7 = new TamGiacDeu(60);
        Hinh h8 = new HinhChuNhat(55, 40);
        Hinh h9 = new HinhChuNhat(40, 30);

        DsHinh arr = new DsHinh();
        arr.themHinh(
                h8, h5, h4, h7, h1, h3, h2, h6, h9
        );

        arr.sapXep1();
        arr.hienThi();
    }
}
