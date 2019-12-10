package 动态规划_leetcode;

public class LeetCode198 {
    /**
     * 状态方程 dp[i] = max(dp[i-1], dp[i-2]+nums[i]
     * 返回dp最后一个元素
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) dp[i] = nums[i];
            else if (i == 1) dp[i] = Math.max(nums[0], nums[1]);
            else dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
