package 周赛167;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

public class Solution_1287 {
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        int[][] dp = new int[8][8];
        for (int i = 0; i < 8; i++) {
            dp[0][i] = 12 + 11 * i;
        }
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 9 - i - 1; j++) {
                dp[i][j] = dp[i - 1][j] * 10 + j + i + 2;
            }
        }
        for (int[] i : dp) {
            for (int j : i) {
                if (j != 0 && j >= low && j <= high) list.add(j);
                else if (j > high) break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int a = 100;
        int b = 500;
        System.out.println(sequentialDigits(a, b));
    }
}
