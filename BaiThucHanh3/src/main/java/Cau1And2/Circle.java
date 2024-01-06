/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau1And2;

/**
 *
 * @author HP
 */
public class Circle extends Ellipse {

    public Circle(double banKinh) {
        super(banKinh, banKinh);
    }

    @Override
    public String getTenHinh() {
        return "Hinh cirle";
    }
}