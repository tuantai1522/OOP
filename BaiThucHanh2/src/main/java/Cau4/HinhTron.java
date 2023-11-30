/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau4.Class;

import Cau1.Class.Diem;

/**
 *
 * @author HP
 */
public class HinhTron {

    private Diem tam;
    private double banKinh;

    public HinhTron(Diem x, double doDai) throws Exception {
        this.tam = x;
        if (doDai > 0) {
            this.banKinh = doDai;
        } else {
            throw new Exception("Invalid input");
        }
    }

    /**
     * @return the tam
     */
    public Diem getTam() {
        return tam;
    }

    /**
     * @param tam the tam to set
     */
    public void setTam(Diem tam) {
        this.tam = tam;
    }

    /**
     * @return the duongKinh
     */
    public double getBanKinh() {
        return banKinh;
    }

    /**
     * @param banKinh
     */
    public void setBanKinh(double banKinh) {
        this.banKinh = banKinh;
    }

    public double tinhChuVi() {
        return this.banKinh * 2 * Math.PI;
    }

    public double tinhDienTich() {
        return Math.pow(this.banKinh, 2) * Math.PI;
    }

    public int xacDinhViTri(Diem x) {
        double khoangCach = this.tam.tinhKhoangCach(x);
        
        //Trong đường tròn
        if (khoangCach < this.banKinh) {
            return 1;
         
        //Trên viền đường tròn
        } else if (khoangCach == this.banKinh) {
            return 0;
        }
        
        //Ngoài đường tròn
        return -1;
    }
     public int xacDinhViTri(HinhTron ht) {
        double khoangCach = this.tam.tinhKhoangCach(ht.tam);
        double tongBanKinh = this.banKinh + ht.banKinh;
        
        //Hai đường tròn trùng nhau
        if (khoangCach == tongBanKinh) {
            return 1;
         
        //Hình tròn này nằm hoàn toàn trong hình tròn khác
        } else if (khoangCach < tongBanKinh) {
            return 0;
        }
        
        //Hình tròn này chạm hình tròn khác
        return -1;
    }
}
