/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.btt.bai3;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class BaiThucHanh3 {

    public static void main(String[] args) {
        try {
            SanPham s1 = new Sach("OOP", 80, 256);
            SanPham s2 = new BangDia("OU1", 120, 12.55);
            
            SanPham s3 = new BangDia("OU2", 431, 18.22);
            
            SanPham s4 = new Sach("Ky thuat lap trinh", 561, 256);
            
            DsSanPham ds = new DsSanPham();
            ds.themSanPham(s1, s2, s3, s4);
            ds.themSanPham("com.mycompany.baithuchanh3.Sach");
            ds.themSanPham("com.mycompany.baithuchanh3.BangDia");
            
            ds.hienThi();
            
            ds.timKiem("com.mycompany.baithuchanh3.BangDia").forEach(x -> x.xuat());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(BaiThucHanh3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
