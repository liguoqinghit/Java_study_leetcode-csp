package 周赛165;

public class Solution_1277 {
    public static int countSquares(int[][] matrix) {
        int num = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j]);
                if (matrix[i][j] == 1){
                    num++;
//                    System.out.println("第" + num);
                    boolean flag = true;
                    int side = 2;
                    while (flag && (i+side) <= matrix.length
                                && (j+side) <= matrix[0].length) {
                        for (int k1 = 0; k1 < side; k1++) {
                            for (int k2 = 0; k2 < side; k2++) {
                                if (matrix[i+k1][i+k2] == 0) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (flag) {
                            side++;
                            num++;
                        }
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(countSquares(matrix));
    }
}
