package 动态规划_leetcode;

public class LeetCode746 {
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
//        int[] cost = {10, 15, 20};
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
