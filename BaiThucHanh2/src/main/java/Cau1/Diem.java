/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau1.Class;

/**
 *
 * @author HP
 */
public class Diem {
    private double hoanhDo;
    private double tungDo;
    
    public Diem(){
        this.hoanhDo = 0;
        this.tungDo = 1;
    }
    
    public Diem(double x, double y){
        this.hoanhDo = x;
        this.tungDo = y;
    }

    /**
     * @return the hoanhDo
     */
    public double getHoanhDo() {
        return hoanhDo;
    }

    /**
     * @param hoanhDo the hoanhDo to set
     */
    public void setHoanhDo(double hoanhDo) {
        this.hoanhDo = hoanhDo;
    }

    /**
     * @return the tungDo
     */
    public double getTungDo() {
        return tungDo;
    }

    /**
     * @param tungDo the tungDo to set
     */
    public void setTungDo(double tungDo) {
        this.tungDo = tungDo;
    }
    
    public void hienThi(){
        System.out.printf("(%.2f, %.2f)\n", this.hoanhDo, this.tungDo);
    }
    public double tinhKhoangCach(Diem d){
        return Math.sqrt(Math.pow(this.hoanhDo - d.hoanhDo, 2) + 
                Math.pow(this.tungDo - d.tungDo, 2));
    }
}
