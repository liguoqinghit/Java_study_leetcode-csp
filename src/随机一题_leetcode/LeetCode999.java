package 随机一题_leetcode;

public class LeetCode999 {
    public static int numRookCaptures(char[][] board) {
        int count = 0, x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < dir.length; i++) {
            count += capture(board, x, y, dir[i]);
        }

        return count;
    }

    public static int capture(char[][] board, int x, int y, int[] dir) {
        int i = x, j = y;
        while (i >= 0 && i < board.length &&
                j >= 0 && j < board.length) {
            if (board[i][j] == 'B') return 0;
            if (board[i][j] == 'p') return 1;
            i += dir[0];
            j += dir[1];
        }
        return 0;
    }

    public static void main(String[] args) {
        char[][] board = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        System.out.println(numRookCaptures(board));
    }
}
