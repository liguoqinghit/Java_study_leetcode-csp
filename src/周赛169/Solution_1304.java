package 周赛169;

public class Solution_1304 {
    public static int[] sumZero(int n) {
        int[] res = new int[n];
        if (n == 1) res[0] = 0;
        else if (n % 2 == 0) {
            for (int i = n / 2, j = 0; i > 0; i--, j++) {
                res[j] = -i;
                res[n - j - 1] = i;
            }
        } else {
            for (int i = (n - 1) / 2, j = 0; i > 0; i--, j++) {
                res[j] = -i;
                res[n - j - 1] = i;
            }
            res[(n - 1) / 2] = 0;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] temp = sumZero(n);
        for (int i : temp) System.out.print(i + " ");
    }
}
