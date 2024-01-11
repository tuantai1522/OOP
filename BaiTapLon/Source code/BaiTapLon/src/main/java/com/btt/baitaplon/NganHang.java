package com.btt.baitaplon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
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

    public List<TaiKhoan> traCuu(String maSo) {
        return null;
    }

    public void sapXepTienGuiGiamDan() {
//        this.DanhSachKhachHang.sort((kh1, kh2) -> {
//            double a = kh1.tinhTongTienGui();
//            double b = kh2.tinhTongTienGui();
//
//            if (a > b) {
//                return -1;
//            } else if (a < b) {
//                return 1;
//            }
//            return 0;
//
//        });

        this.DanhSachKhachHang.sort(
                Comparator.comparingDouble(KhachHang::tinhTongTienGui).reversed()
        );
    }

    public List<KhachHang> getDanhSachKhachHang() {
        return DanhSachKhachHang;
    }

    public KhachHang timKiemKhachHangDuaTrenMaSo(String maSoTaiKhoan) {
        return this.DanhSachKhachHang.stream().filter(x -> x.getMaSoTaiKhoan().equals(maSoTaiKhoan))
                .findFirst()
                .orElse(null);
    }

    public TaiKhoanDangNhap timKiemTaiKhoanDangNhapDuaTrenMaSo(String maSoTaiKhoan) {
        return this.DanhSachDangNhap.stream().filter(x -> x.getUserName().equals(maSoTaiKhoan))
                .findFirst()
                .orElse(null);
    }

    public double tinhTienLaiKhachHangDuaTrenMaSoTaiKhoan(String maSoTaiKhoan) {
        return this.timKiemKhachHangDuaTrenMaSo(maSoTaiKhoan).tinhToanBoTienLai();
    }

    public void moTaiKhoanDangNhap(KhachHang kh) throws Exception {
        //Tao khách hàng
        kh.nhapKhachHang();

        //Add 1 tài khoản không kỳ hạn
        double soTienGui;
        do {
            System.out.print("\nNhap so tien can gui cho tai khoan khong ky han: ");
            try {
                soTienGui = Double.parseDouble(CauHinh.sc.nextLine());

                if (soTienGui < 50) {
                    System.out.println("\nSo tien gui phai lon hon 50");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lua chon phai la chu so. Hay nhap lai.");
                soTienGui = -1;
            }
        } while (soTienGui < 50);

        TaiKhoan tk = new TaiKhoanKhongKyHan(soTienGui);
        kh.moTaiKhoan(tk);

        this.DanhSachKhachHang.add(kh);

        this.ghiDanhSachKhachHang();

        //Tao tài khoản đăng nhập
        TaiKhoanDangNhap tkdn = new TaiKhoanDangNhap(kh.getMaSoTaiKhoan());
        this.DanhSachDangNhap.add(tkdn);
        this.ghiDanhSachDangNhap();

        System.out.println("\nBan da tao tai khoan thanh cong cho khach hang");
        System.out.println(String.format("Username: %s", tkdn.getUserName()));
        System.out.println(String.format("Password: %s", tkdn.getPassWord()));
    }

    public void lamViecVoiGiaoDienAdmin() throws Exception {
        int choice;
        do {
            System.out.println("\n-----------------------CHAO MUNG TOI VOI GIAO DIEN ADMIN-----------------------");
            System.out.println("1. Mo tai khoan khach hang");
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
                        KhachHang kh = new KhachHang();
                        this.moTaiKhoanDangNhap(kh);
                    }
                    case 2 -> {
                        String maSoTaiKhoan;
                        System.out.print("\nBan hay nhap ma so tai khoan cua khach hang can tra cuu: ");
                        maSoTaiKhoan = CauHinh.sc.nextLine();
                        KhachHang kh = this.timKiemKhachHangDuaTrenMaSo(maSoTaiKhoan);
                        if (kh != null) {
                            System.out.println(String.format("Toan bo tien lai cua khach hang (%s) la: %.3f",
                                    kh.getMaSoTaiKhoan(),
                                    this.tinhTienLaiKhachHangDuaTrenMaSoTaiKhoan(maSoTaiKhoan)));
                        } else {
                            System.out.println(String.format("Ma so tai khoan %s khong ton tai",
                                    maSoTaiKhoan));
                        }

                    }
                    case 3 -> {
                        String maSoTaiKhoan;
                        System.out.print("\nBan hay nhap ma so tai khoan cua khach hang can tra cuu: ");
                        maSoTaiKhoan = CauHinh.sc.nextLine();
                        KhachHang kh = this.timKiemKhachHangDuaTrenMaSo(maSoTaiKhoan);
                        if (kh != null) {
                            System.out.println(kh);
                        } else {
                            System.out.println(String.format("Ma so tai khoan %s khong ton tai",
                                    maSoTaiKhoan));
                        }
                    }
                    case 4 -> {
                        String maSoTaiKhoan;
                        System.out.print("\nBan hay nhap ma so tai khoan cua khach hang can tra cuu: ");
                        maSoTaiKhoan = CauHinh.sc.nextLine();
                        KhachHang kh = this.timKiemKhachHangDuaTrenMaSo(maSoTaiKhoan);
                        if (kh != null) {
                            kh.xuatDanhSachTaiKhoan();
                        } else {
                            System.out.println(String.format("Ma so tai khoan %s khong ton tai",
                                    maSoTaiKhoan));
                        }
                    }
                    case 5 -> {
                        this.sapXepTienGuiGiamDan();
//                        this.ghiDanhSachKhachHang();
                        System.out.println("\nSap xep tien gui giam dan thanh cong");
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
        } while (choice != 8);
    }

    public void lamViecVoiGiaoDienKhachHang(KhachHang kh) {
        int choice;
        do {
            System.out.println("\n-----------------------CHAO MUNG TOI VOI GIAO DIEN KHACH HANG-----------------------");
            System.out.println("1. Xem thong tin cua ban");
            System.out.println("2. Mo tai khoan co ky han");
            System.out.println("3. Rut tien");
            System.out.println("4. Gui tien");
            System.out.println("5. Doi mat khau");
            System.out.println("6. Thoat");
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

                    }
                    case 5 -> {
                        String oldPassword;
                        System.out.print("\nBan hay nhap mat khau cu: ");
                        oldPassword = CauHinh.sc.nextLine();

                        TaiKhoanDangNhap tk1 = this.timKiemTaiKhoanDangNhapDuaTrenMaSo(kh.getMaSoTaiKhoan());
                        if (oldPassword.equals(tk1.getPassWord())) {
                            String newPassword;
                            System.out.print("\nBan hay nhap mat khau moi: ");
                            newPassword = CauHinh.sc.nextLine();

                            tk1.setPassWord(newPassword);
                            System.out.print("\nBan da thay doi mat khau thanh cong");

                            this.ghiDanhSachDangNhap();
                        } else {
                            System.out.println("Xac nhan mat khau khong dung");
                        }

                    }
                    case 6 -> {
                        System.out.println("Xin chao va hen gap lai.");
                    }
                    default ->
                        System.out.println("Lua chon khong hop le. Hay nhap lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lua chon phai la chu so. Hay nhap lai.");
                choice = -1;
            }
        } while (choice != 6);
    }

    public boolean isDangNhapHopLe(String userName, String passWord) {
        //Tìm bất cứ khi nào True
        return this.DanhSachDangNhap.stream().anyMatch(tk -> tk.isHopLe(userName, passWord));
    }
}
