package 随机一题_leetcode;

import java.util.Arrays;

public class LeetCode581 {
//    对比 重新创建一个新的数组，排序好
//    从左到右 找到第一个索引值和排好序的 不同的 记作min
//    从右到左 同上 max
//    比较两个索引值，若相同则返回，否则返回max - min + 1
    public static int findUnsortedSubarray(int[] nums) {
        int[] n2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n2[i] = nums[i];
        }
        Arrays.sort(n2);
        int min = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != n2[i]) {
                min = i;
                break;
            }
        }
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] != n2[i]) {
                max = i;
                break;
            }
        }
        if (min == max) return 0;
        return max - min + 1;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int[] nums = {1, 2, 3, 4};
        System.out.println(findUnsortedSubarray(nums));
    }
}
