/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau2.Class;

import Cau1.Class.Diem;

/**
 *
 * @author HP
 */
public class DoanThang {
    private Diem diemDau;
    private Diem diemCuoi;

    public DoanThang(){
        this.diemDau = new Diem(0, 0);
        this.diemCuoi = new Diem(0, 0);
    }
    public DoanThang(Diem d1, Diem d2){
        this.diemDau = d1;
        this.diemCuoi = d2;
    }
    /**
     * @return the diemDau
     */
    public Diem getDiemDau() {
        return diemDau;
    }

    /**
     * @param diemDau the diemDau to set
     */
    public void setDiemDau(Diem diemDau) {
        this.diemDau = diemDau;
    }

    /**
     * @return the diemCuoi
     */
    public Diem getDiemCuoi() {
        return diemCuoi;
    }

    /**
     * @param diemCuoi the diemCuoi to set
     */
    public void setDiemCuoi(Diem diemCuoi) {
        this.diemCuoi = diemCuoi;
    }
    
    public void hienThi(){
        System.out.printf("[(%.2f, %.2f), (%.2f, %.2f)]\n", this.diemDau.getHoanhDo(), this.diemDau.getTungDo(), 
                this.diemCuoi.getHoanhDo(), this.diemCuoi.getTungDo());
    }
    public double tinhDoDai(){
        return this.diemDau.tinhKhoangCach(this.diemCuoi);
    }
    public Diem timTrungDiem(){
        double x = (this.diemDau.getHoanhDo() + this.diemCuoi.getHoanhDo()) / 2;
        double y = (this.diemDau.getTungDo()+ this.diemCuoi.getTungDo()) / 2;
        return new Diem(x, y);
    }
    public boolean isSongSong(DoanThang d){
        double vectorHuong1X = this.diemCuoi.getHoanhDo() - this.diemDau.getHoanhDo();
        double vectorHuong1Y = this.diemCuoi.getTungDo() - this.diemDau.getTungDo();

        double vectorHuong2X = d.diemCuoi.getHoanhDo() - d.diemDau.getHoanhDo();
        double vectorHuong2Y = d.diemCuoi.getTungDo() - d.diemDau.getTungDo();

        return (vectorHuong1X * vectorHuong2Y) == (vectorHuong1Y * vectorHuong2X);
    }
    


}
