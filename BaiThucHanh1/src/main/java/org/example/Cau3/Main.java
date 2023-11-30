package org.example;
import java.util.Scanner;

public class ThirdQuestion {
    //First requirement
    public static String normalizeEmail(String s){
        String normalized = s.trim().replaceAll("\\s+", "");
        return normalized;
    }
    public static String checkEmail(String email){
        //Cấu trúc
        // 1. ^: bắt đầu bằng biểu thức chính qui
        // 2. [A-Za-z0-9._]+: kí tự (a-z) (A-Z) (0-9) (_) (.) (%) (+) (-)
        // 3. @: @
        // 4. [A-Za-z0-9._]+: kí tự (a-z) (A-Z) (0-9) (_) (.) (%) (+) (-)
        // 5. \\.: dấu chấm
        // 6. [A-Za-z]{2,}: là kí tự chữ cái có độ dài ít nhất là 2
        // 7. $: kết thúc bằng biểu thức chính qui

        String regexEmail = "^[A-Za-z0-9._]+@[A-Za-z0-9._]+\\.[A-Za-z]{2,}$";

        if(email.matches(regexEmail)){
            return email.substring(0, email.indexOf("@"));
        }
        return "Email không hợp lệ";
    }

    //Second requirement
    public static int countUpperCharacter(String s){
        int ans = 0;
        for(int i = 0; i < s.length(); ++i){
//            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
//                ++ans;
//            }
            if(Character.isUpperCase(s.charAt(i))){
                ++ans;
            }
        }
        return ans;
    }

    //Fourth requirement
    public static int countCharacter(String s){
        //Cấu trúc
        //1. []: tập hợp các kí tự được xem xét
        //2. \\s: kí tự khoảng trắng
        //3. ,: dấu phẩy
        //4. ;: dấu chấm phẩy
        //5. +: loại bỏ các kí tự thỏa mãn liên tiếp nhau
        String regexString = "[\\s,;]+";
        String arr [] = s.split(regexString);

        if(arr.length > 0){
            String max = arr[0];
            for(int i = 0; i < arr.length; ++i){
                if(max.length() < arr[i].length()){
                    max = arr[i];
                }
            }
            System.out.println("Kí tự dài nhát là: " + max);
        }else {
            System.out.println("Kí tự dài nhát là: ");
        }
        return arr.length;


    }

    //Fifth requirement
    public static String normalizeString(String s){
        s = s.trim().replaceAll("\\s+", " ");

        StringBuilder res = new StringBuilder();

        String words [] = s.split(" ");

        for(int i = 0; i < words.length; ++i){
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
            res.append(words[i] + " ");
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Kiểm tra email");
            System.out.println("2. Đếm kí tự in hoa");
            System.out.println("3. Đọc dữ liệu từ tập tin");
            System.out.println("4. Đếm số từ trong xâu và tìm từ dài nhất");
            System.out.println("5. Chuẩn hóa chuỗi");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > 6) {
                System.out.println("Lựa trong đoạn từ 1 tới 6");
            }

            if (choice == 1) {
                System.out.print("Hãy nhập địa chỉ email của bạn: ");
                scanner.nextLine(); //bỏ qua dòng trống ở lựa chọn trước
                String email = scanner.nextLine();

                //Chuẩn hóa chuỗi trước (xóa toàn bộ khoảng trắng)
                email = normalizeEmail(email);

                String ans = checkEmail(email);

                System.out.println(ans);
            } else if (choice == 2) {
                System.out.print("Hãy nhập 1 chuỗi bất kỳ: ");
                scanner.nextLine(); //bỏ qua dòng trống ở lựa chọn trước
                String s = scanner.nextLine();
                System.out.println("Số lượng kí tự in hoa là: " + countUpperCharacter(s));
            } else if (choice == 3) {

            } else if (choice == 4) {
                System.out.print("Hãy nhập 1 chuỗi bất kỳ: ");
                scanner.nextLine(); //bỏ qua dòng trống ở lựa chọn trước
                String s = scanner.nextLine();
                System.out.println("Số từ trong xâu: " + countCharacter(s));
            } else if (choice == 5) {
                System.out.print("Hãy nhập 1 chuỗi bất kỳ: ");
                scanner.nextLine(); //bỏ qua dòng trống ở lựa chọn trước
                String s = scanner.nextLine();
                System.out.println("Chuỗi sau khi được chuẩn hóa: " + normalizeString(s));
            }
            System.out.println("-----------------------");
        }while(choice != 6);
    }
}
