package com.btt.baitaplon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NganHang {

    private List<KhachHang> DanhSachKhachHang = new ArrayList<>();
    private List<TaiKhoanDangNhap> DanhSachDangNhap = new ArrayList<>();

    public void ghiDanhSachKhachHang() throws Exception {
        //Xóa toàn bộ nội dung trước đó đã có trong file
        Path path = Paths.get(CauHinh.KHACH_HANG_FILE_PATH);
        try {
            Files.write(path, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Lỗi khi xóa nội dung của tập tin: " + e.getMessage());
        }

        // Ghi dữ liệu vào tập tin
        this.DanhSachKhachHang.forEach(kh -> {

            try {
                kh.ghiFile();
            } catch (IOException ex) {
                Logger.getLogger(NganHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(NganHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public void docDanhSachKhachHang() throws Exception {
        // Clear toàn bộ cữ liệu cũ
        this.DanhSachKhachHang.clear();

        File file = new File(CauHinh.KHACH_HANG_FILE_PATH);
        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNext()) {
                KhachHang kh = new KhachHang();

                this.DanhSachKhachHang.add(kh.docFile(sc.nextLine()));
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void xuatDanhSachKhachHang() {
        this.DanhSachKhachHang.forEach(x -> System.out.print(x));
    }

    public void ghiDanhSachDangNhap() {
        //Xóa toàn bộ nội dung trước đó đã có trong file
        Path path = Paths.get(CauHinh.TAI_KHOAN_DANG_NHAP_FILE_PATH);
        try {
            Files.write(path, new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Lỗi khi xóa nội dung của tập tin: " + e.getMessage());
        }

        // Ghi dữ liệu vào tập tin
        this.DanhSachDangNhap.forEach(tk -> {

            try {
                tk.ghiFile();
            } catch (IOException ex) {
                Logger.getLogger(NganHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(NganHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public void docDanhSachDangNhap() throws Exception {
        this.DanhSachDangNhap.clear();

        File file = new File(CauHinh.TAI_KHOAN_DANG_NHAP_FILE_PATH);
        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNext()) {
                TaiKhoanDangNhap tk = new TaiKhoanDangNhap();

                this.DanhSachDangNhap.add(tk.docFile(sc.nextLine()));
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void xuatDanhSachDangNhap() {
        this.DanhSachDangNhap.forEach(x -> System.out.print(x));
    }

    public KhachHang layKhachHangDuaTrenMaSo(String maSoTaiKhoan) {
        return DanhSachKhachHang.stream()
                .filter(kh -> kh.getMaSoTaiKhoan().equals(maSoTaiKhoan))
                .findFirst()
                .orElse(null);
    }

    public void moTaiKhoanKhachHang(KhachHang kh) {
        this.DanhSachKhachHang.add(kh);

    }

    public List<TaiKhoan> traCuu(String maSo) {
        return null;
    }

    public void sapXep() {

    }

    public List<KhachHang> getDanhSachKhachHang() {
        return DanhSachKhachHang;
    }

    public KhachHang timKiemKhachHangDuaTrenMaSo(String maSoTaiKhoan) {
        return this.DanhSachKhachHang.stream().filter(x -> x.getMaSoTaiKhoan().equals(maSoTaiKhoan))
                .findFirst()
                .orElse(null);
    }

    public void lamViecVoiGiaoDienAdmin() {
        int choice;
        do {
            System.out.println("\nCHAO MUNG TOI VOI GIAO DIEN ADMIN");
            System.out.println("\n1. Mo tai khoan");
            System.out.println("2. Tinh tien lai khach hang dua tren so tai khoan cung cap");
            System.out.println("3. Tra cuu thong tin khach hang");
            System.out.println("4. Tra cuu danh sach tai khoan dua tren ma so khach hang");
            System.out.println("5. Sap xep danh sach khach hang co tong so tien gui giam dan");
            System.out.println("6. Xem danh sach khach hang");
            System.out.println("7. Xem danh sach tai khoan dang nhap");
            System.out.println("8. Thoat");
            System.out.print("Ban nhap lua chon: ");
            try {
                choice = Integer.parseInt(CauHinh.sc.nextLine());

                switch (choice) {
                    case 1 -> {
                    }
                    case 2 -> {

                    }
                    case 3 -> {
                    }
                    case 6 -> {
                        this.xuatDanhSachKhachHang();
                    }
                    case 7 -> {
                        this.xuatDanhSachDangNhap();
                    }
                    case 8 -> {
                        System.out.println("Xin chao va hen gap lai.");
                        break;
                    }
                    default ->
                        System.out.println("Lua chon khong hop le. Hay nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lua chon phai la chu so. Hay nhap lai.");
                choice = -1;
            }
        } while (choice != 9);
    }

    public void lamViecVoiGiaoDienKhachHang(KhachHang kh) {
        int choice;
        do {
            System.out.println("CHAO MUNG TOI VOI GIAO DIEN KHACH HANG");
            System.out.println("\n1. Xem thong tin cua ban");
            System.out.println("2. Mo tai khoan co ky han");
            System.out.println("3. Doi mat khau");
            System.out.println("4. Thoat");
            System.out.print("Ban nhap lua chon: ");
            try {
                choice = Integer.parseInt(CauHinh.sc.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.println(kh);
                    }
                    case 2 -> {

                    }
                    case 3 -> {
                    }
                    case 4 -> {
                        System.out.println("Xin chao va hen gap lai.");
                        break;
                    }
                    default ->
                        System.out.println("Lua chon khong hop le. Hay nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lua chon phai la chu so. Hay nhap lai.");
                choice = -1;
            }
        } while (choice != 9);
    }

    public boolean isDangNhapHopLe(String userName, String passWord) {
        return this.DanhSachDangNhap.stream().anyMatch(tk -> tk.isHopLe(userName, passWord));
    }
}
