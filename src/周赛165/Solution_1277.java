package 周赛165;

public class Solution_1277 {
    /**
     * 思路：遍历每个点，若为1，再查看是否能构成边长为2的正方形，
     * 直到构成正方形的某个值为0或达到最大边长(即数组边界)
     * @param matrix
     * @return
     */
    public static int countSquares(int[][] matrix) {
        int num = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1){
                    num++;
                    boolean flag = true;
                    int side = 2;
                    while (flag && (i+side) <= matrix.length
                                && (j+side) <= matrix[0].length) {
                        for (int k1 = 0; k1 < side; k1++) {
                            for (int k2 = 0; k2 < side; k2++) {
                                if (matrix[i+k1][j+k2] == 0) {
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

    /**
     * 动态规划，还没看
     * @param matrix
     * @return
     */
    public int countSquares2(int[][] matrix) {
        //dp[i][j] = 边长分别为ij的矩阵可以由1组成的正方形的个数也等于由该矩阵组成的最大边长
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int [][]dp = new int[m][n] ;
        //对于第一行和第一列，最大的正方形边长就 = matrix数组中该位置的数字
        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0];
            result += matrix[i][0];
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = matrix[0][j];
            result += matrix[0][j];
        }
        if(matrix[0][0] == 1){
            result --;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]) + 1;
                    result += dp[i][j];
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(countSquares(matrix));
    }
}
