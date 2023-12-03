/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau7;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class HocVien {

    private static int dem = 0;
    private int maHV;
    private String tenHV;
    private LocalDate ngaySinh;
    private String queQuan;
    private ArrayList<Double> diem;

    {
        ++dem;
        this.setMaHV(dem);
    }

    public HocVien(String ten, LocalDate ngay, String que) {
        this.tenHV = ten;
        this.ngaySinh = ngay;
        this.queQuan = que;
    }

    public HocVien(String ten, String ngay, String que) {
        this(ten,
                LocalDate.parse(ngay, DateTimeFormatter.ofPattern(Utils.DATE_FORMAT)),
                que);
    }

    public HocVien() {
        this.tenHV = "";
        this.ngaySinh = LocalDate.parse("01/01/1970", DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        this.queQuan = "";

    }

    public void hienThi() {
        System.out.printf("\n%s - %s - %s - %s",
                this.getMaHV(), this.getTenHV(), this.getNgaySinh().format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT)), this.getQueQuan());

        if (getDiem() != null) {
            System.out.print(" - ");
            for (Double d : this.getDiem()) {
                System.out.printf("%.2f ", d);
            }
            System.out.print("- ");
            System.out.printf("%.2f ", this.tinhDiemTrungBinh());

        }
    }

    public void nhapHocVien() {
        System.out.print("\nNhap ten: ");
        this.setTenHV(Utils.sc.nextLine());

        System.out.print("\nNhap ngay sinh(dd/MM/yyyy): ");
        this.setNgaySinh(LocalDate.parse(Utils.sc.nextLine(), DateTimeFormatter.ofPattern(Utils.DATE_FORMAT)));

        System.out.print("\nNhap que quan: ");
        this.setQueQuan(Utils.sc.nextLine());
    }

    public void nhapDiem() {
        diem = new ArrayList<>(Utils.SO_MON);
        for (int i = 0; i < Utils.SO_MON; ++i) {
            System.out.printf("\nNhap diem mon %d: ", i + 1);
            getDiem().add(i, Double.valueOf(Utils.sc.next()));
        }
    }

    /**
     * @return the maHV
     */
    public int getMaHV() {
        return maHV;
    }

    /**
     * @param maHV the maHV to set
     */
    public void setMaHV(int maHV) {
        this.maHV = maHV;
    }

    /**
     * @return the tenHV
     */
    public String getTenHV() {
        return tenHV;
    }

    /**
     * @param tenHV the tenHV to set
     */
    public void setTenHV(String tenHV) {
        this.tenHV = tenHV;
    }

    /**
     * @return the ngaySinh
     */
    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    /**
     * @return the diem
     */
    public ArrayList<Double> getDiem() {
        return diem;
    }

    /**
     * @param diem the diem to set
     */
    public void setDiem(ArrayList<Double> diem) {
        this.diem = diem;
    }

    public double tinhDiemTrungBinh() {
        return diem.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

    }

    public int tinhTuoi() {
        return LocalDate.now().getYear() - this.ngaySinh.getYear();
    }

    public boolean kiemTraCoHocHong() {
        return diem != null && this.tinhDiemTrungBinh() > 8.0
                && this.diem.stream().anyMatch(x -> x < 5.0) == false;
    }
    

}
