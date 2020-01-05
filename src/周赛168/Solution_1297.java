package 周赛168;

public class Solution_1297 {
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int count = 0;
        for (int i = 0; i < s.length()-minSize; i++) {
            String temp = s.substring(i, i + minSize);
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aababcaab";
        int maxLetters = 2, minSize = 3, maxSize = 4;
        System.out.println(maxFreq(s, maxLetters, minSize, maxSize));
    }
}
