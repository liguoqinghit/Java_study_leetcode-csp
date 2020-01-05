package 随机一题_leetcode;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode881 {
    /**
     * 一开始没看见只能乘坐两个人，所以以为能坐n个人。。
     * 排序后，最重的人和另一个一起坐(遍历<=limit就行，其实可以坐好多人。。)
     * 以flag为标志位，记录是否已经上船，true为上船了
     * count记录上船人数，num为返回船数
     * @param people
     * @param limit
     * @return
     */
    public static int numRescueBoats2(int[] people, int limit) {
        if (people.length == 1) return 1;
        int num = 0, count = 0;
//        从大到小 不能用？？？
//        Comparator<Integer> cmp = new Comparator<Integer>() {
//            public int compare(Integer a, Integer b) {
//                return a - b;
//            }
//        };
        Arrays.sort(people);
        int temp = limit;
//        如果减去 flag = true
        boolean[] flag = new boolean[people.length];
        for (int i = people.length - 1; i >= 0; i--) {
            if (people[i] <= temp && !flag[i]) {
                temp -= people[i];
                flag[i] = true;
                count++;
                for (int j = i - 1; j >= 0; j--) {
                    if (people[j] <= temp && !flag[j]) {
                        temp -= people[j];
                        flag[j] = true;
                        count++;
                        temp = limit;
                        num++;
                        break;
                    }
                }
            } else if (people[i] > temp && !flag[i]) {
                temp = limit;
                num++;
                if (i != 0) i++;
            }
            if (count == people.length) {
                break;
            }
        }
        if (!flag[0] || temp != limit) num++;

        return num;
    }

    /**
     * 因为只能坐两个人，所以只需要最轻的和最重的坐一起
     * @param people
     * @param limit
     * @return
     */
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, num = 0;
        while (i <= j) {
            num++;
            if (people[i] + people[j] <= limit) i++;
            j--;
        }
        return num;
    }

    public static void main(String[] args) {
//        int[] people = {1, 2};
//        int limit = 3;
//        int[] people = {3,2,2,1};
//        int limit = 3;
        int[] people = {3,5,3,4};
        int limit = 5;
//        int[] people = {5,1,4,2};
//        int limit = 6;
//        int[] people = {3,2,3,2,2};
//        int limit = 6;
        System.out.println(numRescueBoats(people, limit));
    }
}
