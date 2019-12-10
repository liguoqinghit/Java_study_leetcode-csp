package 动态规划_leetcode;

public class LeetCode392 {
    /**
     * 就是花费的时间比较长
     * 如果s[i] = s[j]
     *       dp[i][j] = dp[i-1][j-1]
     * 否则  dp[i][j] = dp[i][j-1]
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen > tLen) return false;
        if (sLen == 0) return true;

        boolean[][] dp = new boolean[sLen + 1][tLen + 1];
        for (int i = 0; i < tLen; i++) dp[0][i] = true;

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = dp[i][j-1];
            }
        }
        return dp[sLen][tLen];
    }

    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
