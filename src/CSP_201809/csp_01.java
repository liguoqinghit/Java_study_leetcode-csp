package CSP_201809;

import java.util.Scanner;

public class csp_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++)
            price[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int p;
            if (i == 0) p = (price[i] + price[i+1]) / 2;
            else if (i == n-1) p = (price[i] + price[i-1]) / 2;
            else {
                p = (price[i] + price[i-1] + price[i+1]) / 3;
            }
            p = (int) Math.floor(p);
            System.out.print(p + " ");
        }
    }
}

/*
样例输入
8
4 1 3 1 6 5 17 9
样例输出
2 2 1 3 4 9 10 13
 */
