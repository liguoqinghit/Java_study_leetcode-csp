package CSP_201909;
import java.util.Scanner;

public class csp_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0, num = 0, group_num = 0;
        boolean[] fruit = new boolean[n];
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int minn = sc.nextInt();
            for (int j = 1; j < m; j++) {
                int temp = sc.nextInt();
                if (temp > 0 && minn > temp) {
                    fruit[i] = true;
                    minn = temp;
                } else if (temp <= 0) {
                    minn += temp;
                }
            }
            sum += minn;
        }
        for (int i = 0; i < n; i++) {
            if (fruit[i]) {
                num++;
            }
            if (fruit[i] && fruit[(i+1)%n] && fruit[(i+2)%n]) {
                group_num++;
            }
        }
        System.out.print(sum + " ");
        System.out.print(num + " ");
        System.out.println(group_num);
    }
}

/*
测试1
4
4 74 -7 -12 -5
5 73 -8 -6 59 -4
5 76 -5 -10 60 -2
5 80 -6 -15 59 0

222 1 0

测试2
5
4 10 0 9 0
4 10 -2 7 0
2 10 0
4 10 -3 5 0
4 10 -1 8 0

39 4 2

 */