package 动态规划_leetcode;

public class LeetCode62 {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][1] = 1;
        for (int i = 1; i <= n; i++) dp[1][i] = 1;
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println(uniquePaths(m, n));
    }
}
