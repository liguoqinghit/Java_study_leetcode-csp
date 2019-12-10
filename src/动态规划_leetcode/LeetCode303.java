package 动态规划_leetcode;

public class LeetCode303 {
    private static int[] data;

    /*
    将每个加和都保存起来
    要调用sumRange时只需两个加和相减
    data[i]表示 从0到i-1的和
    sumRange(i, j) = nums[i:j] = data[j+1] - data[i]
     */
    public LeetCode303(int[] nums) {
        data = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            data[i+1] = data[i] + nums[i];
        }
    }

    public static int sumRange(int i, int j) {
        return data[j+1] - data[i];
    }

    /*
    暴力
     */
//    public LeetCode303(int[] nums) {
//        data = nums;
//    }
//
//    public static int sumRange(int i, int j) {
//        int sum = 0;
//        for (int a = i; a <= j; a++) sum += data[a];
//        return sum;
//    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        LeetCode303 obj = new LeetCode303(nums);
        System.out.println(obj.sumRange(0, 5));
    }
}
