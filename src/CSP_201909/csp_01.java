package CSP_201909;
import java.util.Scanner;

public class csp_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        long sum = 0, max = 0, index=0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m+1; j++) {
                int num = sc.nextInt();
                sum +=num;
                if (j != 0) {
                    temp += -num;
                }
            }
            if (temp > max) {
                max = temp;
                index = i + 1;
            }
        }
        sc.close();
        System.out.print(sum + " ");
        System.out.print(index + " ");
        System.out.println(max);

    }

}
///*
//3 3
//73 -8 -6 -4
//76 -5 -10 -8
//80 -6 -15 0
//
//167 2 23
// */
