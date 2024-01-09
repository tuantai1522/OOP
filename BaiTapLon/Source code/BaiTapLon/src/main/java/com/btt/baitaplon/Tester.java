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
                        KhachHang kh = new KhachHang(
                                "060120020001",
                                "Nguyen Van A",
                                "07/08/2003",
                                "Tay Ninh",
                                "079202002201"
                        );
                        nh.lamViecVoiGiaoDienKhachHang(kh);
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
