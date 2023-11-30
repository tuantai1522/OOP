/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau3.Class;

import Cau1.Class.Diem;

/**
 *
 * @author HP
 */
public class HinhChuNhat {

    private Diem trenTrai;
    private Diem duoiPhai;

    public HinhChuNhat(Diem x, Diem y) throws Exception {
        if (x.getTungDo() > y.getTungDo()
                && y.getHoanhDo() > x.getHoanhDo()) {
            this.trenTrai = x;
            this.duoiPhai = y;
        } else {
            throw new Exception("Invalid input");
        }
    }

    /**
     * @return the trenTrai
     */
    public Diem getTrenTrai() {
        return trenTrai;
    }

    /**
     * @param trenTrai the trenTrai to set
     */
    public void setTrenTrai(Diem trenTrai) {
        this.trenTrai = trenTrai;
    }

    /**
     * @return the duoiPhai
     */
    public Diem getDuoiPhai() {
        return duoiPhai;
    }

    /**
     * @param duoiPhai the duoiPhai to set
     */
    public void setDuoiPhai(Diem duoiPhai) {
        this.duoiPhai = duoiPhai;
    }

    public double tinhDienTich() {
        Diem temp = new Diem(this.trenTrai.getHoanhDo(), this.duoiPhai.getTungDo());
        double x = this.trenTrai.tinhKhoangCach(temp);
        double y = this.duoiPhai.tinhKhoangCach(temp);
        return x * y;
    }

    public double tinhChuVi() {
        Diem temp = new Diem(this.trenTrai.getHoanhDo(), this.duoiPhai.getTungDo());
        double x = this.trenTrai.tinhKhoangCach(temp);
        double y = this.duoiPhai.tinhKhoangCach(temp);

        return (x + y) / 2;
    }

    public void hienThi() {
        System.out.printf("[(%.2f, %.2f), (%.2f, %.2f)]\n", this.trenTrai.getHoanhDo(), this.trenTrai.getTungDo(),
                this.duoiPhai.getHoanhDo(), this.duoiPhai.getTungDo());
        System.out.printf("Chu vi = %.2f\n", this.tinhChuVi());       
        System.out.printf("Dien tich = %.2f\n", this.tinhDienTich());

    }

}
