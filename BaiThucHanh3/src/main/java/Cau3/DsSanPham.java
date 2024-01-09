/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btt.bai3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class DsSanPham {

    private ArrayList<SanPham> ds = new ArrayList<>();

    /**
     * @return the ds
     */
    public ArrayList<SanPham> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(ArrayList<SanPham> ds) {
        this.ds = ds;
    }

    public void themSanPham(SanPham... sp) {
        this.ds.addAll(Arrays.asList(sp));
    }

    public void themSanPham(String classPath) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {
        Class c = Class.forName(classPath);
        SanPham s = (SanPham) c.getConstructor().newInstance();
        s.nhap();
        this.ds.add(s);
    }

    public void hienThi() {
        this.ds.forEach(x -> x.xuat());
    }

    public SanPham timKiem(int id) {
        return this.ds.stream().filter(x -> x.getId() == id).findFirst().get();
    }

    public List<SanPham> timKiem(String keyWord) throws ClassNotFoundException {
        Class c = Class.forName(keyWord);
        return this.ds.stream().filter(x -> x.getTenSanPham().contains(keyWord) || c.isInstance(x)).collect(Collectors.toList());
    }

    public void sapXep() {
        this.ds.stream().sorted((a, b) -> {
            if(a.getGiaSanPham() > b.getGiaSanPham())
                return 1;
            else if(a.getGiaSanPham() > b.getGiaSanPham())
                return -1;
            return 0;
        });

    }
}
