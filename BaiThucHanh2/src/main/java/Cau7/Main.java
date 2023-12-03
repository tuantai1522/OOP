/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau7;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Main {

    public static void main(String[] args) throws Exception {
        DsHocVien ds = new DsHocVien();
        HocVien h1 = new HocVien("Tran Van On", "01/01/1987", "Ha Nam");
        HocVien h2 = new HocVien("Nguyen Van C", "11/12/2002", "Ha Tinh");
        HocVien h3 = new HocVien("Tran Thi A", "15/06/2010", "Nghe An");

        ds.themHocVien(h1);
        ds.themHocVien(h2);
        ds.themHocVien(h3);

        //ds.themHocVien();
        ds.docDanhSachHocVien();

        ds.hienThiDanhSach();

        //ds.nhapDiem();
        //ds.sapXep();
        ds.hienThiDanhSach();

//        List<HocVien> hv = ds.timKiem("Bang");
//        if (hv != null) {
//            hv.forEach(i -> i.hienThi());
//        }

        ds.ghiFileHocBong();
        ArrayList<HocVien> thongKe = ds.thongKeSoTuoiHocVien(0, 18);
        for(HocVien h : thongKe){
            h.hienThi();
        }

    }
}
