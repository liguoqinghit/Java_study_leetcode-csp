package 周赛165;

public class Solution_1275 {
    public static  String tictactoe(int[][] moves) {
        int[] row = new int[3];
        int[] col = new int[3];
        int[] dia = new int[2];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                row[moves[i][0]] += 1;
                col[moves[i][1]] += 1;
                if (moves[i][0] + moves[i][1] == 2) dia[1] += 1;
                if (moves[i][0] == moves[i][1]) dia[0] += 1;
            } else {
                row[moves[i][0]] -= 1;
                col[moves[i][1]] -= 1;
                if (moves[i][0] + moves[i][1] == 2) dia[1] -= 1;
                if (moves[i][0] == moves[i][1]) dia[0] -= 1;
            }
        }
        for (int i=0; i < 3; i++) {
            if (row[i] == 3 || col[i] == 3) return "A";
            else if (row[i] == -3 || col[i] == -3) return "B";
            else if (i < 2) {
                if (dia[i] == 3 || dia[i] == 3) return "A";
                else if (dia[i] == -3 || dia[i] == -3) return "B";
            }
        }
        if (moves.length == 9) return "Draw";
        else return "Pending";
    }

    public static void main(String[] args) {
//        int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
        int[][] moves = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        System.out.println(tictactoe(moves));

    }
}
