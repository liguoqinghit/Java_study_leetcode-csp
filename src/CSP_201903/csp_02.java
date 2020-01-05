package CSP_201903;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class csp_02 {
    public static double calculate(double a, double b, char c) {
        if (c == '+') return a+b;
        if (c == '-') return a-b;
        if (c == 'x') return a*b;
        else return Math.floor(a/b);
    }

//    枚举法，思路简单，但是需要完全枚举，不能简单的用几个例子算作枚举
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        String[] s = new String[n];
//        for (int i = 0; i < n; i++) {
//            s[i] = sc.nextLine();
//        }
//        for (int i = 0; i < n; i++) {
//            char[] cal = s[i].toCharArray();
////            存储每个数
//            double[] initial = new double[4];
//            initial[0] = (double) (cal[0] - '0');
//            initial[1] = (double) (cal[2] - '0');
//            initial[2] = (double) (cal[4] - '0');
//            initial[3] = (double) (cal[6] - '0');
////            枚举，把8种可能全部列出来
////            以后不能想当然，要适当的举例 尤其时运算不满足交换律(-和/)
////            减法和除法要考虑顺序 不能凭空就让两个数相减或除
////            1-3*3-3
//            double result;
//            if (cal[1] == 'x' || cal[1] == '/') {
//                if (cal[3] == 'x' || cal[3] == '/') {
////                    result = 3 x 3 x 3 ~ 3
//                    double temp1 = calculate(initial[0], initial[1], cal[1]);
//                    double temp2 = calculate(temp1, initial[2], cal[3]);
//                    result = calculate(temp2, initial[3], cal[5]);
//                } else {
////                    result = 3 x 3 + 3 ~ 3
//                    if (cal[5] == 'x' || cal[5] == '/') {
////                        result = 3 x 3 + 3 x 3
//                        double temp1 = calculate(initial[0], initial[1], cal[1]);
//                        double temp2 = calculate(initial[2], initial[3], cal[5]);
//                        result = calculate(temp1, temp2, cal[3]);
//                    } else {
////                        result = 3 x 3 - 3 - 3
//                        double temp1 = calculate(initial[0], initial[1], cal[1]);
//                        double temp2 = calculate(temp1, initial[2], cal[3]);
//                        result = calculate(temp2, initial[3], cal[5]);
//                    }
//                }
//            } else {
//                if (cal[3] == 'x' || cal[3] == '/') {
//                    // result = 3 + 3 x 3 ~ 3
//                    if (cal[5] == 'x' || cal[5] == '/') {
////                        result = 3 + 3 x 3 x 3
//                        double temp1 = calculate(initial[1], initial[2], cal[3]);
//                        double temp2 = calculate(temp1, initial[3], cal[5]);
//                        result = calculate(initial[0], temp2, cal[1]);
//                    } else {
////                        result = 3 - 3 x 3 - 3
//                        double temp1 = calculate(initial[1], initial[2], cal[3]);
//                        double temp2 = calculate(initial[0], temp1, cal[1]);
//                        result = calculate(temp2, initial[3], cal[5]);
//                    }
//                } else {
////                    result = 3 + 3 + 3 ~ 3
//                    if (cal[5] == 'x' || cal[5] == '/') {
////                        result = 3 + 3 + 3 x 3
//                        double temp1 = calculate(initial[2], initial[3], cal[5]);
//                        double temp2 = calculate(initial[0], initial[1], cal[1]);
//                        result = calculate(temp1, temp2, cal[3]);
//                    } else {
////                        result = 3 - 3 - 3 - 3
//                        double temp1 = calculate(initial[0], initial[1], cal[1]);
//                        double temp2 = calculate(temp1, initial[2], cal[3]);
//                        result = calculate(temp2, initial[3], cal[5]);
//                    }
//                }
//            }
//            int a = (int)result;
//            if (a == 24) System.out.println("Yes");
//            else System.out.println("No");
//        }
//
//    }

//    代码来源：https://blog.csdn.net/qq_42196480/article/details/100086494
//    思路：乘除直接算，减号处理数据并入栈加，加直接入栈
    public static boolean judge(String s) {
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> signs = new Stack<Character>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > '0' && c <= '9') nums.push(c - '0');
            else {
                if (c == '+') signs.push(c);
                else if (c == '-') {
                    int r = (-1) * (s.charAt(i + 1) - '0');
                    signs.push('+');
                    nums.push(r);
                    i++;
                } else if (c == 'x') {
                    int l = nums.pop();
                    int r = s.charAt(i + 1) - '0';
                    nums.push(l*r);
                    i++;
                } else if (c == '/') {
                    int l = nums.pop();
                    int r = s.charAt(i + 1) - '0';
                    nums.push(l/r);
                    i++;
                }
            }
        }
        while (!signs.isEmpty()) {
            signs.pop();
            int l = nums.pop();
            int r = nums.pop();
            nums.push(l + r);
        }
        sum = nums.pop();
        return sum == 24;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = br.readLine();
            }
            for (String s : str) {
                if (judge(s)) System.out.println("Yes");
                else System.out.println("No");
            }

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
    }

}

/*
样例输入
2
9+3+4x3
5+4x5x5
样例输出
Yes
No

样例输入
2
5x6/5x4
6x4+4/5
样例输出
Yes
Yes

样例输入
4
1x2x3x4
1x4+5x4
4+2x2x5
6+6+2x6
样例输出
Yes
Yes
Yes
Yes
 */