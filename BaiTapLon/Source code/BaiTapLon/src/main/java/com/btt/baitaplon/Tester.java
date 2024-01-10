/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.btt.baitaplon;

/**
 *
 * @author HP
 */
public class Tester {

    public static void main(String[] args) throws Exception {
        NganHang nh = new NganHang();
        nh.docDanhSachKhachHang();
        nh.docDanhSachDangNhap();

        int choice;
        do {
            System.out.println("\nBan muon dang nhap la quyen gi?");
            System.out.println("1. Admin");
            System.out.println("2. Khach hang");
            System.out.println("3. Thoat");
            System.out.print("Ban nhap lua chon: ");

            try {
                choice = Integer.parseInt(CauHinh.sc.nextLine());

                switch (choice) {
                    case 1 -> {
                        nh.lamViecVoiGiaoDienAdmin();
                    }
                    case 2 -> {
                        String userName;
                        String passWord;
                        System.out.print("\nNhap username (ma so tai khoan): ");
                        userName = CauHinh.sc.nextLine();
                        System.out.print("\nNhap pass word: ");
                        passWord = CauHinh.sc.nextLine();

                        if (nh.isDangNhapHopLe(userName, passWord)) {
                            KhachHang kh = nh.layKhachHangDuaTrenMaSo(userName);
                            nh.lamViecVoiGiaoDienKhachHang(kh);
                        }else{
                            System.out.println("Ten dang nhap hoac mat khau khong dung");
                        }

                    }
                    case 3 -> {
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
        } while (choice != 3);

    }
}
