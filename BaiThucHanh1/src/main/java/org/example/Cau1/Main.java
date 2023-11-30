package org.example;
import java.util.Scanner;

public class FirstQuestion {
    public static void main(String[] args) {
        int randomNumber = (int) (1 + (Math.random() * (101 - 1)));
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Hãy nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > 100) {
                System.out.println("Lựa chọn của bạn phải trong đoạn từ [1, 100]");
            } else if (choice > randomNumber) {
                System.out.println("Số bạn đoán lớn hơn");
            } else if (choice < randomNumber) {
                System.out.println("Số bạn đoán nhỏ hơn");
            } else {
                System.out.println("Bạn đã đoán đúng");
            }
        } while (choice != randomNumber);

        scanner.close();
    }
}
