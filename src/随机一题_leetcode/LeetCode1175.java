package 随机一题_leetcode;

public class LeetCode1175 {
    public static int numPrimeArrangements(int n) {
        if (n < 3) return 1;
        int remainder = 10_0000_0000 + 7;
        long res = 1;
        int sum = 1;
        for (int i = 3; i <= n; i++) {
//            判断质数
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) sum++;
        }
        for (int i = 1; i <= sum; i++) {
            res = (res * i) % remainder;
        }
        for (int j = 1; j <= n - sum; j++) {
            res = (res * j) % remainder;
        }
        res %= remainder;
        return (int)res;
    }

    public static void main(String[] args) {
//        int n = 5;
        int n = 100;
        System.out.println(numPrimeArrangements(n));
    }
}
