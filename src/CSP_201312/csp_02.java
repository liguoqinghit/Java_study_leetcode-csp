package CSP_201312;

import java.util.Scanner;

public class csp_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int sum = 0;
//        第一种，循环 时间和第二种相同
        for (int i = 0, j = 1; i < 11; i++) {
            if (i == 1 || i == 5) continue;
            sum += (s.charAt(i) - '0') * j;
            j++;
        }
//        第二种，枚举法。
//        sum += s.charAt(0) - '0';
//        sum += (s.charAt(2) - '0') * 2;
//        sum += (s.charAt(3) - '0') * 3;
//        sum += (s.charAt(4) - '0') * 4;
//        sum += (s.charAt(6) - '0') * 5;
//        sum += (s.charAt(7) - '0') * 6;
//        sum += (s.charAt(8) - '0') * 7;
//        sum += (s.charAt(9) - '0') * 8;
//        sum += (s.charAt(10) - '0') * 9;
        sum %= 11;
        char a = sum == 10 ? 'X' : (char)(sum + '0');
        if (a == s.charAt(12)) System.out.println("Right");
        else System.out.println(s.substring(0, 12) + a);
    }
}

/*
样例输入
0-670-82162-4
样例输出
Right

样例输入
0-670-82162-0
样例输出
0-670-82162-4
 */