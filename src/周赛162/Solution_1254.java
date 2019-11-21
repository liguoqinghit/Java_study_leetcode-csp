package 周赛162;

public class Solution_1254 {
    public static int closedIsland(int[][] grid) {
        int sum = 0;
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid[0].length-1; j++) {
                if (grid[i][j] == 0) {
                    sum += dfs(grid, i, j);
                }
            }
        }
        return sum;
    }

    public static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 1) {
            return 1;
        }
        grid[i][j] = 1;
        int[] vi = {0, 1, 0, -1};
        int[] vj = {1, 0, -1, 0};
        int num = 1;
        for (int k = 0; k < 4; k++) {
            num = Math.min(num, dfs(grid, i + vi[k], j + vj[k]));
            // 还不知道为啥非得 num和dfs的最小值
//            num = dfs(grid, i + vi[k], j + vj[k]);
        }
        return num;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}};
        System.out.println(closedIsland(grid));
    }
}

/*
class Solution {
    int row = 0, col = 0;
    int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean dfs(int[][] grid, int r, int c) {
        if (r < 0 || r > row - 1 || c < 0 || c > col - 1) {
            return false;
        }
        if (grid[r][c] != 0) {
            return true;
        }
        grid[r][c] = 2;
        boolean flag = true;
        for (int[] dirTmp : direction) {
            if (!dfs(grid, r + dirTmp[0], c + dirTmp[1])) {
                flag = false;
            }
        }
        return flag;
    }
}
 */