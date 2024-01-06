/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btt.baitaplon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author HP
 */
public abstract class TaiKhoan {

    protected String ten;
    protected double laiSuat;
    protected double soTienGui;
    protected LocalDate ngayGui;

    public TaiKhoan(String ten, double laiSuat, double soTienGui) {
        this.ten = ten;
        this.laiSuat = laiSuat;
        this.soTienGui = soTienGui;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f - %.3f - %s",
                this.ten,
                this.soTienGui,
                this.laiSuat,
                this.ngayGui.format(DateTimeFormatter.ofPattern(CauHinh.DATE_FORMAT)));
    }

    public double getSoTienGui() {
        return soTienGui;
    }
}
