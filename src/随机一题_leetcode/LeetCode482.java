package 随机一题_leetcode;

public class LeetCode482 {
//    利用数组暂存
    public static String licenseKeyFormatting2(String S, int K) {
        String s = new String();
        char[] s2 = new char[S.length()];
        int j = 0;
        for (int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            if ((temp >= 'A' && temp <= 'Z') || (temp >= '0' && temp <= '9')) {
                s2[j++] = temp;
            } else if (temp >= 'a' && temp <= 'z') {
                s2[j++] = (char) (temp - 32);
            }
        }
        int count = K;
        for (int i = j - 1; i >= 0; i--) {
            s = s2[i] + s;
            count--;
            if (count == 0 && i != 0) {
                count = K;
                s = '-' + s;
            }
        }

        return s;
    }

//    不用数组暂存
    public static String licenseKeyFormatting3(String S, int K) {
        String s = new String();
        int count = K;
        for (int i = S.length() - 1; i >= 0; i--) {
            char temp = S.charAt(i);
            if ((temp >= 'A' && temp <= 'Z') || (temp >= '0' && temp <= '9')) {
                s = temp + s;
                count--;
            } else if (temp >= 'a' && temp <= 'z') {
                s = (char) (temp - 32) + s;
                count--;
            } else continue;
            if (count == 0) {
                count = K;
                s = '-' + s;
            }
        }
        if (s.length() == 0) return "";
        if (s.charAt(0) == '-') s = s.substring(1);
        return s;
    }

//    对于可变的字符串一般都用StringBuilder
//    因为String变化相当于重新开辟了一个新的String
    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                if (num == K) {
                    sb.append('-');
                    num = 0;
                }
                sb.append((char) (S.charAt(i) >= 'a' && S.charAt(i) <= 'z' ? S.charAt(i) - 32 : S.charAt(i)));
                num++;
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
//        String S = "5F3Z-2e-9-w";
//        int K = 4;
//        String S = "2-5g-3-J";
//        int K = 2;
//        String S = "--a-a-a-a--";
        String S = "---";
        int K = 3;
        System.out.println(licenseKeyFormatting(S, K));
    }
}
