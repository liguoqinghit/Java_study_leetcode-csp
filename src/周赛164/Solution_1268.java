package 周赛164;

import edu.princeton.cs.algs4.ST;

public class Solution_1268 {
    private static int MOD = 1_000_000_007;
    public static int numWays(int steps, int arrLen) {
        int[][] dp = new int[steps+1][steps+1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= Math.min(i, arrLen-1); j++) {
                dp[i][j] = dp[i-1][j];
                if (j > 0) {
                    dp[i][j] += dp[i-1][j-1];
                    dp[i][j] %= MOD;
                }
                if (j < i) {
                    dp[i][j] += dp[i-1][j+1];
                }
                System.out.print("dp:" + dp[i][j] + " i:" + i + " j:" + j + " ");
            }
            System.out.println();
        }
        return dp[steps][0];
    }

    public static void main(String[] args) {
        int steps = 6;
        int arrlen = 3;
        System.out.println(numWays(steps, arrlen));

    }

}
