package CSP_201809;

import CSP_201403.csp_04;

import java.util.Scanner;

public class csp_02 {
    /*
    思路：找到有他们俩有交集的时间段
    h:- - -|  - -
      1 2 3 4 5 6 7 8 9
    w:  - - -|- - -
    上图有交集的就是
    1. h[2,3]和w[2,3] 可交谈的时间是1
    2. h[5,6]和w[5,6] 可交谈的时间是1
    所以可以先找到h或w的终止时间在另一个人的装车时间段里面，然后用这个时间减去他们俩当前时间段的最大起始时间
    比如第一个交集，h的终止时间是3 在w的[2,4]装车时间段里面，
    然后这段可交谈的时间就等于 3 - max(h的起始时间1, w的起始时间2) = 3 - 2 = 1
    依次找到有交集的部分

    可以剪枝，但是对于csp的结果(除了代码长度变长了，时间多了一点)影响不大，并没有想象中的剪枝情况
    剪枝代码已注释
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] h = new int[n][2];
        int[][] w = new int[n][2];
        csp_04.input(sc, n, n, h, w);
        sc.close();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (w[j][0] < h[i][1] && w[j][1] >= h[i][1]) {
                    sum += h[i][1] - Math.max(w[j][0], h[i][0]);
                } else if (h[i][0] < w[j][1] && h[i][1] >= w[j][1]) {
                    sum += w[j][1] - Math.max(w[j][0], h[i][0]);
                }
//                剪枝，可以减少循环次数，但是提交后并未发生太多改变
//                思路: 当w或h的起始时间大于等于另一个的终止时间，就可以不再遍历了
//                else if (w[j][0] >= h[i][1] || w[j][1] <= h[i][0]) continue;
            }
        }
        System.out.println(sum);
    }

}

/*
样例输入
4
1 3
5 6
9 13
14 15
2 4
5 7
10 11
13 14
样例输出
3
 */
