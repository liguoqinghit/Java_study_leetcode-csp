package 随机一题_leetcode;

public class LeetCode1143 {
    public static int longestCommonSubsequence(String text1, String text2) {
        int index = -1, sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text1.length(); i++) {
            sb.append(text1.charAt(i));
            System.out.println(text2.indexOf(text1.charAt(i)));
            if (text2.contains(sb)) {
                sum = Math.max(sum, sb.length());
                continue;
            } else {
                sb = new StringBuilder();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String text1, text2;
        text1 = "abcde";
        text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
}
