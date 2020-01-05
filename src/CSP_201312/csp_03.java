package CSP_201312;

import java.util.Scanner;
import java.util.Stack;

public class csp_03 {
    //    dp 动态记录每个位置的最大面积
//    估计由于范围太大，分数90(n=1000,h=10000,跑的时间过长)
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = 1000;
        int[][] dp = new int[n][10000];
        int area = 0;
        for (int i = 0; i < n; i++) {
//            int temp = sc.nextInt();
            int temp = 10000;
            if (i == 0) {
                for (int j = 0; j < temp; j++) {
                    dp[i][j] = j + 1;
                    area = Math.max(dp[i][j], area);
                }
            } else {
                for (int j = 0; j < temp; j++) {
                    dp[i][j] = dp[i-1][j] + j + 1;
                    area = Math.max(dp[i][j], area);
                }
            }
        }
        sc.close();
        System.out.println(area);
    }
     */
    /*
//    暴力法
//    从h[i]到h[j]可以构成的矩形面积 = (j - i + 1) * h
//    此时的h为h[i]到h[j]的最小值
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        sc.close();
        int area = 0;
        for (int i = 0; i < n; i++) {
            int height = h[i];
            for (int j = i; j < n; j++) {
                if (height > h[j]) {
                    height = h[j];
                }
                area = Math.max(area, height * (j - i + 1));
            }
        }
        System.out.println(area);
    }

     */

//    利用堆栈 实现O(n)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n + 1];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        sc.close();
        h[n] = 0;
        int area = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            if (s.empty() || h[s.peek()] < h[i]) s.push(i);
            else {
                int id_temp = s.pop();
                int area_temp = h[id_temp] * (s.empty() ? i : i - s.peek() - 1);
                area = Math.max(area, area_temp);
                i--;
            }
        }
        System.out.println(area);
    }
}

/*
样例输入
6
3 1 6 5 2 3
样例输出
10
 */
