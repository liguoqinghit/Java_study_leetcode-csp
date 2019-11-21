package 周赛162;

public class Solution_1252 {
//    public static int oddCells(int n, int m, int[][] indices) {
//        int[][] ind = new int[n][m];
//        for (int[] i:indices) {
//            for (int j = 0; j < m; j++) {
//                ind[i[0]][j] = 1 - ind[i[0]][j];
//            }
//            for (int j = 0; j < n; j++) {
//                ind[j][i[1]] = 1 - ind[j][i[1]];
//            }
//        }
////        for (int[] i : ind) {
////            for (int j : i) {
////                System.out.print(j + " ");
////            }
////            System.out.println();
////        }
//
//        int sum = 0;
//        for (int[] i : ind) {
//            for (int j : i) {
//                sum += j;
//            }
//        }
//
//        return sum;
//    }
    public static int oddCells(int n, int m, int[][] indices) {
        boolean[] r = new boolean[n];
        boolean[] c = new boolean[m];
        int i;
        for (i = 0; i < indices.length; i++) {
            r[indices[i][0]] = !r[indices[i][0]];
            c[indices[i][1]] = !c[indices[i][1]];
        }
        int rr = 0, cc = 0;
        for (i = 0; i < r.length; i++) {
            if(r[i])rr++;
        }
        for (i = 0; i < c.length; i++) {
            if(c[i])cc++;
        }
        System.out.println(rr);
        System.out.println(cc);
        return rr * m + cc * n - rr * cc * 2;
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(oddCells(n, m, indices));

    }
}

/* 方法2

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
         boolean[] r = new boolean[n];
        boolean[] c = new boolean[m];
        int i;
        for (i = 0; i < indices.length; i++) {
            r[indices[i][0]] = !r[indices[i][0]];
            c[indices[i][1]] = !c[indices[i][1]];
        }
        int rr = 0, cc = 0;
        for (i = 0; i < r.length; i++) {
            if(r[i])rr++;
        }
        for (i = 0; i < c.length; i++) {
            if(c[i])cc++;
        }
        return rr * m + cc * n - rr * cc * 2;
    }
}
 */