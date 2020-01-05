package 随机一题_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        getAns(nums, 0, new ArrayList<>(), lists);
        return lists;
    }

    public static void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, lists);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = subsetsWithDup(nums);
        while (!lists.isEmpty()) {
            System.out.println(lists.remove(0));
        }
    }
}
