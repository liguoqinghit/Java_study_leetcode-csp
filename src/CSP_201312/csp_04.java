package CSP_201312;

import java.util.Scanner;

public class csp_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] a = new long[n][6];
        a[0][0] = 1;
        long mod = 1_000_000_007;
        for (int i = 1; i < n; i++) {
            a[i][0] = (a[i - 1][0]) % mod;
            a[i][1] = (a[i - 1][0] + a[i - 1][1] * 2) % mod;
            a[i][2] = (a[i - 1][0] + a[i - 1][2]) % mod;
            a[i][3] = (a[i - 1][1] + a[i - 1][3] * 2) % mod;
            a[i][4] = (a[i - 1][1] + a[i - 1][2] + a[i - 1][4] * 2) % mod;
            a[i][5] = (a[i - 1][3] + a[i - 1][4] + a[i - 1][5] * 2) % mod ;
        }
        System.out.println(a[n - 1][5]);
        for (long[] i : a) {
            for (long j : i) System.out.print(j + " ");
            System.out.println();
        }
    }
}

/*
样例输入
4
样例输出
3
解释
2013 2031 2301

5
2 0 1 3

 */
