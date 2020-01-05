package 动态规划_leetcode;

public class LeetCode1025 {
    public static boolean divisorGame(int N) {
        if (N == 1) return false;
        if (N == 2) return true;
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = (int)Math.sqrt(i); j > 1; j--) {
                if (i % j == 0 && !dp[i - j]) dp[i] = true;
            }
            if (!dp[i]) dp[i] = !dp[i-1];
        }
        for (boolean i : dp) System.out.print(i + " ");
        return dp[N];
    }

//    观察结果，
    public boolean divisorGame2(int N) {
        if (N == 1) {
            return false;
        }
        return N % 2 == 0;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(divisorGame(n));
    }
}
