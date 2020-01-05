package 随机一题_leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode893 {
    public static int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int[] count = new int[52];
            for (int j = 0; j < A[i].length(); j++) {
                char k = A[i].charAt(j);
                count[k - 'a' + 26 * (j % 2)]++;
            }
            set.add(Arrays.toString(count));
        }
        return set.size();
    }

    public static void main(String[] args) {
//        String[] A = {"a","b","c","a","c","c"};
        String[] A = {"abc","cba","cdc"};
        System.out.println(numSpecialEquivGroups(A));
    }
}
