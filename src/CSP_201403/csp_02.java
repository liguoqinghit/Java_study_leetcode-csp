package CSP_201403;

import java.util.Scanner;
import java.util.Stack;

public class csp_02 {
    /**
     * 借助堆栈去保存数组的索引，利用get从顶部(n-1)遍历堆栈
     * 如果当前点所在的窗口不是顶部的，将这个原位置删除再放到顶部
     * 如果所有窗口都不包含当前点，即j = 0 时还没有break此时
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] coordinate = new int[n * 2][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            coordinate[2 * i][0] = sc.nextInt();
            coordinate[2 * i][1] = sc.nextInt();
            coordinate[2 * i + 1][0] = sc.nextInt();
            coordinate[2 * i + 1][1] = sc.nextInt();
            stack.push(i);
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            for (int j = n - 1; j >= 0; j--) {
                int k = stack.get(j);
                if (x >= coordinate[2 * k][0] && x <= coordinate[2 * k + 1][0] &&
                        y >= coordinate[2 * k][1] && y <= coordinate[2 * k + 1][1]) {
                    if (k != stack.peek()) {
                        stack.remove(stack.indexOf(k));
                        stack.push(k);
                    }
                    System.out.println(k + 1);
                    break;
                }
                if (j == 0) {
                    System.out.println("IGNORED");
                }
            }
        }
    }
}

/*
样例输入
3 4
0 0 4 4
1 1 5 5
2 2 6 6
1 1
0 0
4 4
0 5
样例输出
2
1
1
IGNORED
 */