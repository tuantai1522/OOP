/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cau3;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Demo {

    public static void main(String[] args) throws Exception {
        int choice;
        QLSanPham ds = new QLSanPham();
        Scanner sc = new Scanner(System.in);
        ds.docFileSanPham();

        do {
            System.out.println("\n1. Them san pham");
            System.out.println("2. Xoa san pham");
            System.out.println("3. Cap nhat san pham");
            System.out.println("4. Tim kiem");
            System.out.println("5. Sap xep gia giam");
            System.out.println("6. Xem danh sach");
            System.out.println("7. Thoat");
            System.out.print("Ban chon: ");
            choice = sc.nextInt();

            if (choice < 1 || choice > 7) {
                System.out.println("Ban da nhap sai lua chon. Xin nhap lai");

            }

            switch (choice) {
                case 1 -> {
                    int choose;
                    do {
                        System.out.println("1. Them sach");
                        System.out.println("2. Them bang dia");
                        System.out.println("3. Thoat");
                        System.out.print("Ban chon: ");

                        choose = sc.nextInt();

                        if (choose < 1 || choose > 3) {
                            System.out.println("Ban da nhap sai lua chon. Xin nhap lai");
                        }
                        switch (choose) {
                            case 1 -> {
                                SanPham sp = new Sach();
                                sp.nhapSanPham();
                                ds.themSanPham(sp);
                            }
                            case 2 -> {
                                SanPham sp = new BangDia();
                                sp.nhapSanPham();
                                ds.themSanPham(sp);
                            }
                            case 3 -> {
                                break;
                            }
                        }
                    } while (choose != 3);
                }

                case 2 -> {
                    int id;
                    System.out.print("Hay nhap ma san pham de xoa: ");
                    id = sc.nextInt();

                    ds.xoaSanPham(id);
                }

                case 3 -> {
                }

                case 4 -> {
                    int choose;
                    do {
                        System.out.println("\n1. Tim theo ma");
                        System.out.println("2. Tim theo ten");
                        System.out.println("3. Tim theo khoang gia");
                        System.out.println("4. Thoat");
                        System.out.print("Ban chon: ");

                        choose = sc.nextInt();

                        if (choose < 1 || choose > 4) {
                            System.out.println("Ban da nhap sai lua chon. Xin nhap lai");
                        }
                        switch (choose) {
                            case 1 -> {
                                int id;
                                System.out.println("Hay nhap ma san pham can tim: ");
                                id = sc.nextInt();
                                SanPham sp = ds.timKiem(id);
                                if (sp != null) {
                                    System.out.println("Da tim thay ma san pham co id la : " + id);
                                    sp.xuatSanPham();
                                } else {
                                    System.out.println("Khong tim thay san pham co : " + id);
                                }
                            }
                            case 2 -> {
                                String kw;
                                System.out.println("Hay nhap ten san pham can tim: ");
                                kw = sc.nextLine();
                                QLSanPham list = ds.timKiem(kw);
                                if (list != null) {
                                    list.hienThi();
                                } else {
                                    System.out.println("Khong tim thay san pham co ten: " + kw);
                                }
                            }
                            case 3 -> {
                                double giaMin, giaMax;
                                System.out.print("Hay nhap gia min: ");
                                giaMin = sc.nextDouble();
                                System.out.print("Hay nhap gia max: ");
                                giaMax = sc.nextDouble();
                                QLSanPham list = ds.timKiem(giaMin, giaMax);
                                if (list != null) {
                                    list.hienThi();
                                } else {
                                    System.out.println("Khong tim thay san pham co gia tu " + giaMin + " toi " + giaMax);
                                }
                            }
                            default -> {
                                break;
                            }
                        }
                    } while (choose != 4);
                }
                case 5 -> {
                    ds.sapXep();
                }
                case 6 -> {
                    ds.hienThi();
                }
                case 7 -> {
                    break;
                }
            }

        } while (choice != 7);
    }
}
