package 随机一题_leetcode;

import java.util.Arrays;

public class LeetCode628 {
//    暴力 超出时间范围
    public static int maximumProduct2(int[] nums) {
        int max = Integer.MIN_VALUE;
//        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int temp = nums[i] * nums[j] * nums[k];
                    if (temp > max) max = temp;
                }
            }
        }
        return max;
    }

//    暴力 排序后 找到n-1最大的两个数相乘，最后乘以nums[nums.length-1]即最大值
    public static int maximumProduct(int[] nums) {
        if (nums.length == 3) return nums[0] * nums[1] * nums[2];
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int temp = nums[i] * nums[j];
                if (temp > max) max = temp;
            }
        }
        return max * nums[nums.length - 1];
    }

//    找到最小的两个和最大值相乘或最大的三个相乘
//    排序后找到0,1,n-1  n-3,n-2,n-1这两种乘积最大的
    public static int maximumProduct3(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

//    找到最大的三个值和最小的两个值
//    与上一个思路相同
    public static int maximumProduct4(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) min2 = n;

            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) max3 = n;
        }
        return Math.max(max3 * max2, min1 * min2) * max1;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {-5, -2, 0, 1, 2, 3, 4};
        System.out.println(maximumProduct4(nums));
    }
}
