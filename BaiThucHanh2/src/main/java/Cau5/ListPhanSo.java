/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author HP
 */
public class ListPhanSo {

    private ArrayList<PhanSo> arr = new ArrayList<>();

    /**
     * @return the arr
     */
    public ArrayList<PhanSo> getArr() {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(ArrayList<PhanSo> arr) {
        this.arr = arr;
    }

    public void themPhanSo(PhanSo p) {
        this.arr.add(p.rutGon());
    }

    public void themPhanSo() {
        PhanSo p = new PhanSo();
        p.nhapPhanSo();
        this.arr.add(p.rutGon());
    }

    public void themPhanSo(PhanSo... a) {
        this.arr.addAll(Arrays.asList(a));
    }

    public void hienThiDanhSachPhanSo() {
        this.arr.forEach(x -> x.hienThi());
    }

    public PhanSo tinhTongCacPhanSo() {
        return this.arr.stream()
                .reduce(new PhanSo(), (t, x) -> t.congPhanSo(x))
                .rutGon();

    }

    public PhanSo timMaxPhanSo() {
        PhanSo max = arr.get(0);
        for (PhanSo x : arr) {
            if (max.soSanh(x) == -1) {
                max = x;
            }
        }

        return max;
    }
}
