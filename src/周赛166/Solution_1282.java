package 周赛166;

import java.util.ArrayList;
import java.util.List;

public class Solution_1282 {
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> a = new ArrayList<>();
        int[] num = new int[groupSizes.length+1];
        for (int i = 0; i < groupSizes.length; i++) {
            boolean flag = false;
            for (List<Integer> array:a) {
                if (array.contains(i)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            num[groupSizes[i]] = groupSizes[i];
            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < groupSizes.length; j++) {
                if (groupSizes[j] == groupSizes[i]) {
                    temp.add(j);
                    num[groupSizes[i]]--;
                }
                if (num[groupSizes[i]] == 0) {
                    break;
                }
            }
            a.add(temp);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople(a));
    }
}
