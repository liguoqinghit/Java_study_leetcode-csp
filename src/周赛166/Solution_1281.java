package 周赛166;

public class Solution_1281 {
    public static int subtractProductAndSum(int n) {
        int product = 1;
        int addition = 0;
        while (n > 0) {
            product *= (n % 10);
            addition += (n % 10);
            n /= 10;
        }
        return product-addition;
    }

    public static void main(String[] args) {
        int n = 705;
        System.out.println(subtractProductAndSum(n));
    }
}
