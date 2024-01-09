/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btt.bai4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuanLyTaiKhoan {
    private ArrayList<TaiKhoan> ds = new ArrayList<>();

    /**
     * @return the ds
     */
    public List<TaiKhoan> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(ArrayList<TaiKhoan> ds) {
        this.ds = ds;
    }
    
    public void traCuu(String keyWord){
        this.ds.stream().filter(t -> t.getSoTk().equals(keyWord) || t.getTenTk().contains(keyWord));
    }
}
