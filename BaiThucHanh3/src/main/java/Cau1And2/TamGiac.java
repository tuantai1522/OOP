/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau1And2;

/**
 *
 * @author HP
 */
public class TamGiac extends Hinh {

    private double a;
    private double b;
    private double c;

    public TamGiac(double a, double b, double c) throws Exception {
        if (a < b + c && b < a + c && c < a + b) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else {
            throw new Exception("Invalid input");
        }
    }

    /**
     * @return the a
     */
    public double getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public double getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * @return the c
     */
    public double getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(double c) {
        this.c = c;
    }

    @Override
    public String getTenHinh() {
        return "Hinh tam giac";
    }

    public double tinhNuaChuVi() {
        return (this.a + this.b + this.c) / 2;
    }

    @Override
    public double tinhChuVi() {
        return this.tinhNuaChuVi() * 2;
    }

    @Override
    public double tinhDienTich() {
        double p = this.tinhNuaChuVi();
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public void hienThi() {
        System.out.printf("%s - %.2f - %.2f\n", this.getTenHinh(), this.tinhChuVi(), this.tinhDienTich());

    }

}
