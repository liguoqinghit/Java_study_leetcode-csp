package 动态规划_leetcode;

public class LeetCode53 {
    /**
     * dp[i] = max(dp[i-1]+nums[i], nums[i])
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int num_max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] > 0) dp[i] = dp[i-1] + nums[i];
            else dp[i] = nums[i];
            num_max = Math.max(num_max, dp[i]);
        }
        return num_max;
    }

//    public static int maxSubArray(int[] nums) {
//        int max = nums[0];
//        int lastmax = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if(max > 0) {
//                max += nums[i];
//            } else {
//                max = nums[i];
//            }
//            lastmax = Math.max(lastmax, max);
//        }
//        return lastmax;
//    }

    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {1, 5, 2, 4, 5, 9};
        System.out.println(maxSubArray(nums));

    }
}
