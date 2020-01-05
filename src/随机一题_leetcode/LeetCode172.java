package 随机一题_leetcode;

public class LeetCode172 {
    public static int trailingZeroes(int n) {
//        可以转化为统计乘数中5的个数
//        因为尾数为0就可以看作 * 10，每个10都有一个尾数0
//        10 = 2 * 5， 2可以看作某个偶数，所以2的个数一定比5多，所以可以转化
//        n/5可以看作是 n里面5的倍数  n/5/5是25的倍数 依次类推
//        把这些加和就是5的个数
        int count = 0;
        if (n < 5) return 0;
        while (n > 5) {
            count += n/5;
            n /= 5;
        }
//        while (sum != 0) {
//            if (sum % 10 == 0) count++;
//            sum %= 10;
//        }
//        System.out.println(sum);
//        String s = Integer.toString(sum);
//        计算sum有几个零
//        int l = 0, h = s.length() - 1;
//        while (l < h) {
//            if (s.charAt(l) == '0') count++;
//            if (s.charAt(h) == '0') count++;
//            l++;
//            h--;
//        }
//        for (int i = s.length()-1; i > 0; i--) {
//            if (s.charAt(i) == '0') count++;
//            else break;
//        }
        return count;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(trailingZeroes(n));
    }
}
