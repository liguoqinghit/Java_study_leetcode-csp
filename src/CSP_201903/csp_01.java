package CSP_201903;

import java.math.BigDecimal;
import java.util.Scanner;

public class csp_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        if (n == 1) {
            System.out.print(nums[0] + " " + nums[0] + " " + nums[0]);
            return;
        }
        int max = 0, min = 0;
        if (nums[0] > nums[1]) {
            max = nums[0];
            min = nums[n - 1];
        } else {
            min = nums[0];
            max = nums[n - 1];
        }
        if (n % 2 != 0) {
            int mid = nums[(n - 1) / 2];
            System.out.print(max + " " + mid + " " + min);
        } else {
            float mid = (float) ((nums[(n + 1) / 2] + nums[(n - 1) / 2]) / 2.0);
//            别人修改数据时使用的，虽然这道题用不到(因为小数点后面只可能有0.5)
//            double mid2 = new BigDecimal(mid).setScale(1, BigDecimal.ROUND_DOWN).doubleValue();
            if (mid == (int) mid)
                System.out.print(max + " " + (int) mid + " " + min);
            else
                System.out.print(max + " " + mid + " " + min);
//                System.out.print(max + " " + mid2 + " " + min);
        }

    }
}
/*
样例输入
3
-1 2 4
样例输出
4 2 -1

样例输入
4
-2 -1 2 4
样例输出
4 0.5 -2

样例输入
4
-2 -1 3 4
样例输出
4 1 -2
 */