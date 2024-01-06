/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau1And2;

/**
 *
 * @author HP
 */
public class Ellipse extends Hinh {

    private double bkTrucLon;
    private double bkTrucBe;

    public Ellipse(double bkTrucLon, double bkTrucBe) {
        this.bkTrucLon = bkTrucLon;
        this.bkTrucBe = bkTrucBe;
    }

    /**
     * @return the bkTrucLon
     */
    public double getBkTrucLon() {
        return bkTrucLon;
    }

    /**
     * @param bkTrucLon the bkTrucLon to set
     */
    public void setBkTrucLon(double bkTrucLon) {
        this.bkTrucLon = bkTrucLon;
    }

    /**
     * @return the bkTrucBe
     */
    public double getBkTrucBe() {
        return bkTrucBe;
    }

    /**
     * @param bkTrucBe the bkTrucBe to set
     */
    public void setBkTrucBe(double bkTrucBe) {
        this.bkTrucBe = bkTrucBe;
    }

    @Override
    public double tinhDienTich() {
        return Math.PI * this.bkTrucBe * this.bkTrucLon;
    }

    @Override
    public double tinhChuVi() {
        return 2 * Math.PI
                * Math.sqrt((Math.pow(this.bkTrucLon, 2.0) + Math.pow(this.bkTrucBe, 2.0)) / 2);
    }

    @Override
    public String getTenHinh() {
        return "Hinh ellipse";
    }

}
