/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Cau1.Class.Diem;
import Cau3.Class.HinhChuNhat;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Diem d1 = new Diem(1, 3);
        Diem d2 = new Diem(3, 2);
        
        HinhChuNhat hcn = new HinhChuNhat(d1, d2);
        hcn.hienThi();
    }
    
}
