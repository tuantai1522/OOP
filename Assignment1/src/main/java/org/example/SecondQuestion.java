package org.example;

import java.util.Scanner;

public class SecondQuestion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, x;
        do {
            System.out.print("Hãy nhập số nguyên dương n: ");
            n = scanner.nextInt();

            if(n < 0){
                System.out.println("Số nguyên dương n phải lớn hơn 0");
            }

        } while (n < 0);
        int arr [] = new int[n + 1];
        int ans = 0;
        int level = n;

        for(int i = 0; i < n + 1; ++i){
            System.out.print("Hãy nhập hệ số bậc " + i + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Hãy nhập số giá trị x: ");
        x = scanner.nextInt();

        for(int i = n; i >= 0; --i){
            ans += arr[i] * Math.pow(x * 1.0, level--);
            System.out.println(ans);
        }
        System.out.println("Giá trị của đa thức là: " + ans);
    }
}
