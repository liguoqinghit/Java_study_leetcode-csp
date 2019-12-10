package 拉勾;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 递归和回溯 {
    /*
    递归
    如何将一个问题的规模变小
    自顶向下
    最经典问题 汉诺塔
    步骤
    第一步：判断输入或者状态是否非法 完整性检查
    第二步：判断递归是否应当结束？
    第三步：缩小问题规模
    第四步：整合结果

    分析时间复杂度
    1. 迭代法
    2. 公式法(计算递归函数复杂度最方便的工具)
    T(n) = a * T(n / b) + f(n)
    f(n) 指每次递归完毕后，额外的计算执行时间
    时间复杂度O(n^log_b a)

     */
//    leetcode 91
    public static int numDecoding(String s) {
        char[] chars = s.toCharArray();
        return decode(chars, chars.length - 1);
    }

    public static int decode(char[] chars, int index) {
        if (index <= 0) return 1;
        int count = 0;
        char curr = chars[index];
        char prev = chars[index - 1];

        if (curr > '0') count = decode(chars, index - 1);
        if (prev == '1' || (prev == '2' && curr <= '6')) {
            count += decode(chars, index - 2);
        }
        return count;
    }

//    leetcode 247
    public static List<String> helper(int n, int m) {
        List<String> res = new ArrayList<String>();
        if (n < 0 || m < 0 || n > m) return res;

        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, m);

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }

        return res;
    }
    /*
    回溯
    每次都有多个选择
    步骤
    第一步：判断输入或状态是否非法
    第二步：判断递归是否应当结束
    遍历所有可能出现的情况
        第三步：尝试下一步的可能性
        第四步：回溯到上一步
     */
//    leetcode39
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtraking(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    public static void backtraking(int[] candidates, int target, int start,
                                   List<Integer> solution, List<List<Integer>> results) {
        if (target < 0) return;
        if (target == 0) {
            results.add(solution);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            solution.add(candidates[i]);
            backtraking(candidates, target - candidates[i], i, solution, results);;
            solution.remove(solution.indexOf(candidates[i]));
        }
    }

//    leetcode52


}
