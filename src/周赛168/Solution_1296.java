package 周赛168;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_1296 {
//    超出时间限制
    public static boolean isPossibleDivide2(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        boolean flag = true;
//        Arrays.sort(nums);
        Map<Integer, Integer> dic = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (dic.get(i) != null) {
                int temp = dic.get(i);
                dic.put(i, ++temp);
            } else {
                dic.put(i, 1);
            }
        }
//        不一定要用到减一，减去其中最小值
        for (int i : dic.keySet()) {
            int temp = dic.get(i);
            while (temp != 0) {
                boolean f = true;
                int m = Integer.MAX_VALUE;
                for (int j = 0; j < k; j++) {
                    if (dic.containsKey(i + j) && dic.get(i + j) != 0) {
                        m = Math.min(m, dic.get(i+j));
                    } else {
                        f = false;
                        break;
                    }
                }
                if (f) {
                        for (int j = 0; j < k; j++) {
                            int v = dic.get(i + j) - m;
                            dic.put(i + j, v);
                        }
                        temp = dic.get(i);
                } else break;
            }
        }
        for (int i : dic.values()) {
            if (i != 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

//    利用map存储，遍历
//    map.getOrDefault的用法get
    public static boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int needSet = len / k;
        for (int num : nums) {
            int curCount = map.get(num);
            if (curCount == 0) continue;
            map.put(num, curCount - 1);
            for (int i = 1; i < k; i++) {
                int count = map.getOrDefault(num + i, 0);
                if (count == 0) return false;
                map.put(num + i, count - 1);
            }
            needSet--;
            if (needSet == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,3,4,4,5,6};
//        int k = 4;
//        int[] nums = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
//        int k = 3;
//        int[] nums = {1, 2, 3, 5, 5, 6};
//        int k = 3;
//        int[] nums = {3, 3, 2, 2, 1, 1};
//        int k = 3;
        int[] nums = {3,2,1,2,3,4,3,4,5,9,10,11};
        int k = 3;
        System.out.println(isPossibleDivide(nums, k));
    }
}
