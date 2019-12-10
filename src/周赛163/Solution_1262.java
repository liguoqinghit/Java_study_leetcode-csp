package 周赛163;

import java.util.List;

public class Solution_1262 {

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int maxSumDivThree(int[] nums) {
        int[] f = {0, -1, -1};
        int[] g = new int[3];
        for (int i : nums) {
            for (int j = 0; j < 3; j++)
                g[j] = f[j];
            for (int j = 0; j < 3; j++) {
                if (f[j] != -1) {
                    g[(i + j) % 3] = max(g[(i + j) % 3], f[j]+i);
                }
            }
            for (int j = 0; j < 3; j++)
                f[j] = g[j];
        }
        return f[0];
    }



    public static void main(String[] args) {
        int[] nums = {3,6,5,1,8};
        int result = maxSumDivThree(nums);
        System.out.println(result);

    }
}
