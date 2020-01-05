package CSP_201403;

import java.util.Scanner;

public class csp_04 {
    public static void main(String[] args) {
//        还没做完
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt(), r = sc.nextInt();
        int[][] router = new int[n][2];
        int[][] transit = new int[m][2];
        input(sc, n, m, router, transit);
        r *= r;
        System.out.println(r);
    }

    public static void input(Scanner sc, int n, int m, int[][] router, int[][] transit) {
        for (int i = 0; i < n; i++) {
            router[i][0] = sc.nextInt();
            router[i][1] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            transit[i][0] = sc.nextInt();
            transit[i][1] = sc.nextInt();
        }
    }
}
