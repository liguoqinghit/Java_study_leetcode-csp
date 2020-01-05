package 随机一题_leetcode;



public class LeetCode859 {
//    暴力 超出限制
    public static boolean buddyStrings2(String A, String B) {
        if (A.length() != B.length()) return false;
        for (int i = 0; i < A.length() - 1; i++) {
            for (int j = 1; j < A.length(); j++) {
                if (i == j) continue;
                StringBuilder temp = new StringBuilder(A);
                String c1 = String.valueOf(temp.charAt(i));
                String c2 = String.valueOf(temp.charAt(j));
                temp.replace(i, i+1, c2);
                temp.replace(j, j+1, c1);
                if (temp.toString().equals(B)) return true;
            }
        }
        return false;
    }

//    分情况讨论
//    A = B：查找A中是否有相同的两个元素
//    A != B：查找不相同的位置，如果大于2返回false
//    A != B：根据不同位置，交叉查看值是否相同
    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
//        A == B
        if (A.equals(B)) {
            for (int i = 0; i < A.length() - 1; i++) {
                if (A.indexOf(A.charAt(i), i + 1) != -1) return true;
            }
            return false;
        }
//        A != B
//        A和B有大于2的不同时返回false
        int num = 0;
        int[] index = new int[3];
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                index[num++] = i;
                if (num > 2) return false;
            }
        }
//        只有2个不同
        if (A.charAt(index[0]) == B.charAt(index[1]) &&
                A.charAt(index[1]) == B.charAt(index[0]))
            return true;
        return false;
    }

    public static void main(String[] args) {
//        String A = "ab", B = "ba";
//        String A = "abcd", B = "abcd";
        String A = "aa", B = "aa";
//        A = "aaaaaaabc";
//        B = "aaaaaaacb";
        A = "abcaa";
        B = "abcbb";


        System.out.println(buddyStrings(A, B));

    }
}
