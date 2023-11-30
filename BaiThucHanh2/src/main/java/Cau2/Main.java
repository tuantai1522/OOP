/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Cau1.Class.Diem;
import Cau2.Class.DoanThang;

/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        Diem d1 = new Diem(0, 1);
        Diem d2 = new Diem(1, 0);
        Diem d3 = new Diem(0, 2);
        Diem d4 = new Diem(2, 0);

        DoanThang dt1 = new DoanThang(d1, d2);
        DoanThang dt2 = new DoanThang(d3, d4);

        dt1.hienThi();
        Diem trungDiem = dt1.timTrungDiem();
        trungDiem.hienThi();
        System.out.println(dt1.isSongSong(dt2));

    }
}
