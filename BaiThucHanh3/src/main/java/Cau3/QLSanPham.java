/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau3;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author HP
 */
public class QLSanPham {

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

    public void hienThi() {
        this.ds.forEach(x -> x.xuatSanPham());
    }

    public void themSanPham(SanPham sp) {
        this.ds.add(sp);
    }

    public void xoaSanPham(SanPham sp) {
        this.ds.remove(sp);
    }

    public void xoaSanPham(int id) {
        Iterator<SanPham> iterator = this.ds.iterator();
        while (iterator.hasNext()) {
            SanPham sp = iterator.next();
            if (sp.getMaSanPham() == id) {
                iterator.remove();
                System.out.println("Đã xóa sản phẩm có ID: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có ID: " + id);
    }

    public void sapXep() {
        this.ds.sort((a, b) -> {
            if (a.getGiaBan() > b.getGiaBan()) {
                return -1;
            } else if (a.getGiaBan() < b.getGiaBan()) {
                return 1;
            }
            return a.getTenSanPham().compareTo(b.getTenSanPham());
        }
        );
    }

    public SanPham timKiem(int id) {
        for (SanPham x : this.ds) {
            if (x.getMaSanPham() == id) {
                return x;
            }
        }
        return null;
    }

    public QLSanPham timKiem(Predicate<SanPham> dieuKien) {
        QLSanPham ql = new QLSanPham();
        this.ds.stream()
                .filter(dieuKien)
                .forEach(x -> ql.themSanPham(x));

        return ql;
    }

    public QLSanPham timKiem(String kw) {
        QLSanPham ql = timKiem(x -> x.getTenSanPham().toLowerCase().contains(kw.toLowerCase()));
        return ql;
    }

    public QLSanPham timKiem(double giaMin, double giaMax) {
        QLSanPham ql = timKiem(x -> x.getGiaBan() >= giaMin && x.getGiaBan() <= giaMax);
        return ql;
    }

    public void docFileSanPham() throws Exception {
        File file = new File("src/main/resources/sach.txt");
        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNext()) {
                SanPham sp = new Sach(sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine(),
                        Double.parseDouble(sc.nextLine()), // Sửa dấu đóng ngoặc
                        Integer.parseInt(sc.nextLine()));

                this.ds.add(sp);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        file = new File("src/main/resources/bangdia.txt");
        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNext()) {
                SanPham sp = new BangDia(sc.nextLine(),
                        sc.nextLine(),
                        sc.nextLine(),
                        Double.parseDouble(sc.nextLine()), // Sửa dấu đóng ngoặc
                        Integer.parseInt(sc.nextLine()));

                this.ds.add(sp);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
