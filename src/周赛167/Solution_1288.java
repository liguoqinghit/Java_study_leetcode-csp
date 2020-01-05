package 周赛167;

public class Solution_1288 {
    public static int maxSideLength(int[][] mat, int threshold) {
        int side = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] <= threshold) {
                    side = Math.max(side, 1);
                    int side2 = 2;
                    int sum = 0;
                    while ((i+side2) <= mat.length
                            && (j+side2) <= mat[0].length) {
                        sum = 0;
                        for (int k1 = 0; k1 < side2; k1++)
                            for (int k2 = 0; k2 < side2; k2++)
                                sum += mat[i + k1][j + k2];
                        if (sum <= threshold) side2++;
                        else break;
                    }
                    if ((i + side2) > mat.length || (j + side2) > mat[0].length || sum > threshold) side2--;
                    if ((i + side2) <= mat.length && (j +side2) <= mat[0].length)
                        side = Math.max(side, side2);
                }
            }
        }
        return side;
    }

    public static void main(String[] args) {
//        int[][] mat = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
//        int threshold = 4;
        int[][] mat = {{1,1,1,1},{1,0,0,0},{1,0,0,0},{1,0,0,0}};
        int threshold = 6;
        System.out.println(maxSideLength(mat, threshold));
    }
}
