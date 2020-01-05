package 随机一题_leetcode;

public class LeetCode476 {
    public int findComplement2(int num) {
        int ans = 0;
        int tmp = 1;
        while (num != 0) {

            if ((num & 1) == 0) { //将当前为置为1
                ans |= tmp;
            }
            tmp <<= 1;
            num >>>= 1;
        }
        return ans;
    }

    public static int findComplement(int num) {
        int[] n = new int[32];
        int i = 0;
        while (num != 0) {
            n[i++] = num % 2;
            num /= 2;
        }
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += (int)Math.pow(2, j) * (n[j] == 1 ? 0 : 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(10));
        int temp = 1;
        temp <<= 1;
        System.out.println(temp);
        temp >>>= 1;
        System.out.println(temp);
    }
}
