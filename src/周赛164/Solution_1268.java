package 周赛164;

public class Solution_1268 {
    private static int MOD = 1_000_000_007;

    /**
     * 动态规划（dynamic programming）
     * dp[i][j]表示在位置j，还可以走的步数为i
     * 在走i步时，最远距离为min（x， arrLen）
     * 当我们还有i步的时候，假设我们的位置是j
     * 那么位置j只能由
     * 1.位置j-1，走了i-1步，需要向右移1步
     * 2.位置j,走了i-1步，需要不动
     * 3.位置j+1,走了i-1步，需要向左移1步
     * 最后返回dp[steps][0]
     * @param steps
     * @param arrLen
     * @return
     */
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
