package CSP_201403;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class csp_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (l.contains(-temp)) count++;
            l.add(temp);
        }
        System.out.println(count);
    }
}

/*
样例输入
5
1 2 3 -1 -2
样例输出
2
 */