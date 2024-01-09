/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.btt.bai4;

import java.time.LocalDate;

/**
 *
 * @author admin
 */
public enum KyHan {
    MOT_TUAN(7, 0.5) {
        @Override
        public LocalDate tinhKyHan(LocalDate d) {
            return d.plusDays(this.khoangThoiGian);
        }

        @Override
        public double tinhTienLai(double d) {
            return d * this.laiSuat * 0.005 / 12 / 7;
        }
    },
    MOT_THANG(1, 4.5) {
        @Override
        public LocalDate tinhKyHan(LocalDate d) {
            return d.plusMonths(this.khoangThoiGian);
        }

        @Override
        public double tinhTienLai(double d) {
            return d * this.laiSuat * 0.68 / 12;

        }
    };

    protected int khoangThoiGian;
    protected double laiSuat;

    private KyHan(int khoangThoiGian, double laiSuat) {
        this.khoangThoiGian = khoangThoiGian;
        this.laiSuat = laiSuat;
    }

    /**
     * @return the khoangThoiGian
     */
    public int getKhoangThoiGian() {
        return khoangThoiGian;
    }

    /**
     * @param khoangThoiGian the khoangThoiGian to set
     */
    public void setKhoangThoiGian(int khoangThoiGian) {
        this.khoangThoiGian = khoangThoiGian;
    }

    public abstract LocalDate tinhKyHan(LocalDate d);

    public abstract double tinhTienLai(double d);

}
