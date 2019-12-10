package 动态规划_leetcode;

public class LeetCode5 {
    /**
     * 判断字符串s是否为回文串
     * @param s 字符串s
     * @return 若是，true；否则false
     */
    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len/2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1))
                return false;
        }
        return true;
    }

    /**
     * 找到最长回文子串
     * 暴力法
     * 列举出所有字串，判断是否为回文串，保存最长的
     * 提交的时候时间可能会超出，多提交几次
     * @param s 字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome1(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                String temp = s.substring(i, j);
                if (isPalindromic(temp) && temp.length() > max) {
                    ans = temp;
                    max = temp.length();
                }
            }
        }
        return ans;
    }

    public static String longestPalindrome2(String s) {
        if (s.equals("")) return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int len = s.length();
        int[][] arr = new int[len][len];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) arr[i][j] = 1;
                    else arr[i][j] = arr[i-1][j-1] + 1;
                }
                if (arr[i][j] > maxLen) {
                    maxLen = arr[i][j];
                    maxEnd = i;
                }
            }
        }
        return s.substring(maxEnd-maxLen+1, maxEnd+1);
    }
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(longestPalindrome1(s));
        System.out.println(longestPalindrome2(s));
    }
}
