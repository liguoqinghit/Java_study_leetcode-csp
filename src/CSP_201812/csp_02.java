package CSP_201812;

import java.util.Scanner;

public class csp_02 {
    public static void main(String[] args) {
//        思路: 除了0，直接加，其余的根据对应情况来判断
//        判断: 根据当前时间和该位置的初始状态来判断(以初始状态画一个轴)
//            考虑到时间的范围(10^6)和n的范围(10^6)，时间要用long
        Scanner sc = new Scanner(System.in);
        long r = sc.nextInt();
        long y = sc.nextInt();
        long g = sc.nextInt();
        int n = sc.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long temp = sc.nextInt();
            long t = sc.nextInt();
            if (temp == 0) sum += t;
            else if (temp == 1) {
                if (sum <= t) sum = t;
                else {
                    t = (r - t + sum) % (r + y + g);
                    if (t < r) sum += r - t;
                    else if (t >= g + r) sum += r + r + y + g - t;
                }
            } else if (temp == 2) {
                if (sum <= t) sum = r + t;
                else {
                    t = (y - t + sum) % (r + y + g);
                    if (t < y + r) sum += y + r - t;
                }
            } else {
                if (sum < t) continue;
                else {
                    t = (g - t + sum) % (r + y + g);
                    if (t < g) continue;
                    else sum += r + y + g - t;
                }
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
46
 */
