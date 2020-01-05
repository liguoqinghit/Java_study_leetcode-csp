package 随机一题_leetcode;

public class LeetCode306 {
    public static boolean isAdditiveNumber2(String num) {
        int start = 0, first = 1, second = 1, third = 1;
        int last_start = 0;
//        1 1 2 3 5 8
//        0 1 2 3 4 5
        while (start + first + second + third - 1 < num.length()) {
            last_start = start;
            if (cal(num, start, first, second, third)) {
            } else if (cal(num, start, first, second, third + 1)) {
                third++;
                first = second;
                second = third;
            } else if (cal(num, start, first, second + 1, third + 1)) {
                second++;
                third++;
                first = second;
                second = third;
            } else if (cal(num, start, first + 1, second + 1, third + 1)) {
                second++;
                third++;
                first = second;
                second = second;
            } else start++;
            start = start + first;
        }
        if (start + first + second + third >= num.length()) start = last_start;
        if (cal(num, start, first, second, third)) return true;
        else return false;
    }
    public static boolean isAdditiveNumber(String num) {
        return backtrack(num, 0, 0, 0, 0);
    }

    public static boolean backtrack(String num, int index, long presum, long prenum, int k) {
        if (k > 2 && index >= num.length()) return true;
        for (int len = 1; len + index <= num.length(); len++) {
            long f = isSum(prenum, num, index, index + len -1, k);
            if (f >= 0 && backtrack(num, index + len, f + prenum, f, k + 1))
                return true;
        }
        return false;
    }

    public static long isSum(long sum, String num, int l, int h, int k) {
        if (num.charAt(l) == '0' && l < h) return -1;
        long s = 0;
        while (l <= h) {
            s  = s * 10 + num.charAt(l) - '0';
            l++;
        }
        if (k < 2) return s;
        return sum == s ? s : -1;
    }
    public static boolean cal(String num, int start, int first, int second, int third) {
        if (start + first + second + third - 1 < num.length()) {
            int f = Integer.parseInt(num.substring(start, start + first));
            int s = Integer.parseInt(num.substring(start + first, start + first + second));
            int t = Integer.parseInt(num.substring(start + first + second, start + first + second + third));
            System.out.println(f + " " + s + " " + t + " ");
            if (f + s == t) return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        String num = "112358";
        String num = "199100199";
        System.out.println(isAdditiveNumber(num));
    }
}
