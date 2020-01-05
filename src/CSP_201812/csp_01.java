package CSP_201812;

import java.util.Scanner;

public class csp_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int y = sc.nextInt();
        int g = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp == 0) sum += sc.nextInt();
            else if (temp == 1) sum += sc.nextInt();
            else if (temp == 2) sum += (sc.nextInt() + r);
            else {
                sc.nextLine();
                continue;
            }
        }
        System.out.println(sum);
    }
}

/*
样例输入
30 3 30
8
0 10
1 5
0 11
2 2
0 6
0 3
3 10
0 3
样例输出
70
 */