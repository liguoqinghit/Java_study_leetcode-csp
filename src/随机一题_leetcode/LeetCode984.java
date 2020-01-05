package 随机一题_leetcode;

public class LeetCode984 {
    public static String strWithout3a3b(int A, int B) {
        StringBuilder stringBuilder = new StringBuilder();
        int min = A < B ? A : B, max = A < B ? B : A;
        char mi = A < B ? 'a' : 'b', ma = A < B ? 'b' : 'a';
        int i = 0, j = 0;
        while (i <= min && j < max) {
            stringBuilder.append(ma);
            j++;
            if (j % 2 == 0 && (i + 1) <= min) {
                stringBuilder.append(mi);
                i++;
            }
        }
        int k = 1;
        while ((i+1) <= min) {
            stringBuilder.insert(k, mi);
            i++;
            k += 4;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        int A = 1, B = 2;
//        int A = 4, B = 4;
        int A = 4, B = 1;
        System.out.println(strWithout3a3b(A, B));
    }
}
