/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author HP
 */
public class DsHocVien {

    private ArrayList<HocVien> ds = new ArrayList<>();

    /**
     * @return the ds
     */
    public ArrayList<HocVien> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(ArrayList<HocVien> ds) {
        this.ds = ds;
    }

    public void themHocVien(HocVien hv) {
        this.ds.add(hv);
    }

    public void themHocVien() {
        HocVien hv = new HocVien();
        hv.nhapHocVien();
        this.ds.add(hv);
    }

    public void docDanhSachHocVien() throws Exception {
        File file = new File(Utils.HOC_VIEN_FILE_PATH);
        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNext()) {
                HocVien hv = new HocVien(sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine());

                this.themHocVien(hv);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void hienThiDanhSach() {
        this.ds.forEach(x -> x.hienThi());
    }

    public void nhapDiem() {
        for (HocVien hv : this.ds) {
            System.out.printf("\nNhap diem cho hoc vien %s: ", hv.getTenHV());
            hv.nhapDiem();
        }
    }

    public void nhapDiem(int maSo) {
        for (HocVien hv : this.ds) {
            if (hv.getMaHV() == maSo) {

                System.out.printf("\nNhap diem cho hoc vien %s: ", hv.getTenHV());
                hv.nhapDiem();
                return;
            }
        }
    }

    public HocVien timKiem(int maSo) {
        return this.ds.stream().filter(hv -> hv.getMaHV() == maSo)
                .findFirst().orElse(null);
    }

    public List<HocVien> timKiem(String kw) {
        return this.ds.stream().filter(hv -> hv.getTenHV().contains(kw))
                .collect(Collectors.toList());
    }

    public void sapXep() {
        this.ds.sort((a, b) -> Double.compare(a.tinhDiemTrungBinh(), b.tinhDiemTrungBinh()));
    }

    public void ghiFileHocBong() throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Utils.HOC_BONG_FILE_PATH))) {
            DecimalFormat df = new DecimalFormat("#.##");
            this.ds.forEach(x -> {
                try {
                    if (x.kiemTraCoHocHong()) {
                        writer.write(String.valueOf(x.getMaHV()));
                        writer.write(" - ");
                        writer.write(String.valueOf(x.getTenHV()));
                        writer.write(" - ");
                        writer.write(String.valueOf(df
                                .format(x.tinhDiemTrungBinh())));
                        writer.newLine();

                    }
                } catch (IOException e) {
                    System.err.println("Error writing to file: " + e.getMessage());
                }

            });

            System.out.println("\nDu lieu da duoc ghi vao tep");
        } catch (IOException e) {
            throw new Exception("Invalid input");
        }
    }

    public ArrayList<HocVien> thongKeSoTuoiHocVien(int begin, int end) {
        return this.ds.stream()
                .filter(x -> x.tinhTuoi() >= begin && x.tinhTuoi() <= end)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
