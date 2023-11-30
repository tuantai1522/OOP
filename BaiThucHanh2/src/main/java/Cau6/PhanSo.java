/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau6;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class PhanSo {

    private int tuSo;
    private int mauSo;

    public PhanSo() {
        this.tuSo = 0;
        this.mauSo = 1;
    }

    public PhanSo(int x, int y) {
        this.tuSo = x;
        this.mauSo = y;
    }

    /**
     * @return the tuSo
     */
    public int getTuSo() {
        return tuSo;
    }

    /**
     * @param tuSo the tuSo to set
     */
    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    /**
     * @return the mauSo
     */
    public int getMauSo() {
        return mauSo;
    }

    /**
     * @param mauSo the mauSo to set
     */
    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }

    public static int timUCLN(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        a = Math.abs(a);
        b = Math.abs(b);

        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }

        return a;
    }

    public PhanSo rutGon() {
        int ucln = timUCLN(this.tuSo, this.mauSo);
        return new PhanSo(this.tuSo / ucln, this.mauSo / ucln);
    }

    public PhanSo congPhanSo(PhanSo p1) {
        int tu = this.tuSo * p1.mauSo + this.mauSo * p1.tuSo;
        int mau = this.mauSo * p1.mauSo;
        return new PhanSo(tu, mau).rutGon();
    }

    public PhanSo truPhanSo(PhanSo p1) {
        int tu = this.tuSo * p1.mauSo - this.mauSo * p1.tuSo;
        int mau = this.mauSo * p1.mauSo;
        return new PhanSo(tu, mau).rutGon();
    }

    public PhanSo nhanPhanSo(PhanSo p) {
        int tu = this.tuSo * p.tuSo;
        int mau = this.mauSo * p.mauSo;
        return new PhanSo(tu, mau).rutGon();

    }

    public PhanSo chiaPhanSo(PhanSo p) {
        PhanSo temp = new PhanSo(p.mauSo, p.tuSo);
        return temp.nhanPhanSo(this).rutGon();
    }

    public int soSanh(PhanSo p) {
        //1: PhanSo this lớn hơn p
        //-1: PhanSo this nhỏ hơn p
        //0: PhanSo this bằng p
        double a = this.tuSo * 1.0 / this.mauSo;
        double b = p.tuSo * 1.0 / p.mauSo;
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        }
        return 0;
    }

    public void hienThi() {
        System.out.printf("%d/%d\t", this.tuSo, this.mauSo);
    }

    public void nhapPhanSo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tu so = ");
        this.tuSo = sc.nextInt();

        System.out.print("Mau so = ");
        this.mauSo = sc.nextInt();
    }
}
