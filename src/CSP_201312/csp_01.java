package CSP_201312;

import java.util.*;

public class csp_01 {
    /*
//    直接法，创建一个10001大小的数组记录每个数的次数，数组的下标就是这个数
//    遍历数组找到最大的就可以了
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[10001];
        for (int i = 0; i < n; i++) {
            nums[sc.nextInt()]++;
        }
        int max = 1;
        int time = nums[1];
        for (int i = 2; i < 10001; i++) {
            if (nums[i] > time) {
                time = nums[i];
                max = i;
            }
        }
        System.out.println(max);
    }
     */
    public static void main(String[] args) {
//        利用HashMap 定义一个字典
//        <值, 次数>
        HashMap<Integer, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
        sc.close();
        int p = 10000;
        Integer time = Collections.max(map.values());
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == time) {
                int p2 = m.getKey();
                if (p2 < p) p = p2;
            }
        }
        System.out.println(p);

    }
}

/*
样例输入
6
10 1 10 20 30 20
样例输出
10
 */