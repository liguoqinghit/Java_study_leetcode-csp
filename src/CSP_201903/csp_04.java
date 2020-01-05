package CSP_201903;

import java.util.Scanner;

public class csp_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
//        我的想法：以一个数组保存每个进程的状态，0是无，1是S，-1是R
//        根据第一列的RS后面的值给数组赋值，如果是0就继续读对应的字符串数组
//        时间复杂度预计是O(n^2) 最大的时候是10000^2，估计已经超出了时间限制
//        从网上看到说这题考的是拓扑排序，考虑图的有无环
//        递归：https://blog.csdn.net/qq_42375636/article/details/100742039
    }
}
/*
样例输入
3 2
R1 S1
S0 R0
R1 S1
R0 S0
R1 R1 R1 R1 S1 S1 S1 S1
S0 S0 S0 S0 R0 R0 R0 R0
样例输出
0
1
0
 */
