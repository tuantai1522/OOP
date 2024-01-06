/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau1And2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author HP
 */
public class DsHinh {

    private ArrayList<Hinh> ds = new ArrayList<>();

    public void themHinh(Hinh h) {
        this.ds.add(h);
    }

    public void themHinh(Hinh... h) {
        this.ds.addAll(Arrays.asList(h));
    }

    public void hienThi() {
        this.ds.forEach(x -> x.hienThi());
        System.err.printf("Tinh dien tich trunh binh: %.2f", this.tinhDienTichTrungBinh());

    }

    public double tinhDienTichTrungBinh() {
//        Trong Hinh có phương thức tinhDienTich
        return this.ds.stream()
                .mapToDouble(Hinh::tinhDienTich)
                .average()
                .orElse(0.0);
    }

    public void sapXep1() {
        this.ds.sort((a, b) -> {
            double x = a.tinhDienTich();
            double y = b.tinhDienTich();

            if (x > y) {
                return 1;
            } else if (x < y) {
                return -1;
            }
            return 0;
        });
    }

    public void sapXep2() {
        this.ds.sort((a, b) -> {
            String s1 = a.getTenHinh();
            String s2 = b.getTenHinh();
            //Nếu trùng tên thì sắp xếp diện tích giảm dần
            if (s1.equals(s2)) {
                double x = a.tinhDienTich();
                double y = b.tinhDienTich();

                if (x > y) {
                    return -1;
                } else if (x < y) {
                    return 1;
                }
                return 0;
            }
            return s1.compareTo(s2);
        });
    }
}
