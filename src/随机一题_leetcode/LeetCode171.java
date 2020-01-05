package 随机一题_leetcode;

public class LeetCode171 {
    public static int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = (26 * sum + (s.charAt(i) - 'A' + 1));
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "AB";
        System.out.println(titleToNumber(s));
    }
}
