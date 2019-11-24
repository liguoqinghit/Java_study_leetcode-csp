package 周赛164;

public class Solution_1266 {
    /**
     * 1.计算每行和每列的和
     * 2.再遍历有服务器的点，判断改行或该列的和是否大于1
     *  即存在服务器和该位置的服务器相连，计数器+1
     * @param grid
     * @return
     */
    public static int countServers(int[][] grid) {
        int sum = 0;
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 0}, {1, 1}};
//        int[][] points = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(countServers(points));

    }
}
