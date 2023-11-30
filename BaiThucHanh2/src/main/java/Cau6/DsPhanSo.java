/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau6;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author HP
 */
public class DsPhanSo {

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

    public void themPhanSo() {
        PhanSo p = new PhanSo();
        p.nhapPhanSo();
        this.arr.add(p);
    }
    
    public void themPhanSo(PhanSo... p) {
        this.arr.addAll(Arrays.asList(p));
    }

    public void hienThiDanhSach() {
        this.arr.forEach(x -> x.hienThi());
    }

    public void xoaPhanSo(PhanSo p) {
        this.arr.removeIf(q -> q.soSanh(p) == 0);
    }

    public void xoaPhanSo(int tu, int mau) {
        this.xoaPhanSo(new PhanSo(tu, mau));
    }

    public PhanSo tinhTongCacPhanSo() {
        return this.arr.stream()
                .reduce(new PhanSo(), (t, x) -> t.congPhanSo(x))
                .rutGon();
    }

    public PhanSo timMax() {
        return this.arr.stream()
                .max((a, b) -> a.soSanh(b)).get();
    }

    public PhanSo timMin() {
        return this.arr.stream()
                .min((a, b) -> a.soSanh(b)).get();
    }
    
    public void sapXepTangDan(){
        this.arr.sort((a, b) -> a.soSanh(b));
    }
    
    public void sapXepGiamDan(){
        this.arr.sort((a, b) -> b.soSanh(a));
    }
}
