package 算法;

import java.util.Arrays;
import java.util.Scanner;
// 记录下自己在算法（第4版）所打过的代码和注释，以及自己对部分代码的优化

public class 算法 {
    /**
     * 第一个
     * 计算两个非负整数p和q的最大公约数
     * 若q是0，则最大公约数为p
     * 否则，将p除以q得到余数r，p和q的最大公约数即为q和r的最大公约数
     * @param p
     * @param q
     * @return 返回最大公约数
     */
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static int gcd2(int p, int q) {
        if (q == 0) return p;
        return gcd2(q, p%q);
    }

    /**
     * 第二个
     * 二分查找
     * @param key
     * @param a
     * @return 查找到了返回位置，否则返回-1
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    /**
     * 第三个
     * 计算平方根（牛顿迭代法）
     * @param c
     * @return
     */
    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c/t) > err*t)
            t = (c / t + t) / 2.0;
        return t;
    }

    public static void main(String[] args) {
//        第一个
//        System.out.println(gcd2(30, 50));
//        第二个
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] arr = str.split(" ");
//        int[] whitelist = new int[arr.length];
//        for (int i = 0; i < whitelist.length; i++) {
//            whitelist[i] = Integer.parseInt(arr[i]);
//        }
//        Arrays.sort(whitelist);
//        int key = sc.nextInt();
//        System.out.println(rank(key, whitelist));
//        第三个
        int a = 4;
        System.out.println(Math.sqrt(a));
        System.out.println(sqrt(a));
    }
}
