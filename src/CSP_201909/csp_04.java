package CSP_201909;
import java.util.Scanner;
//参考网址
//https://blog.csdn.net/richenyunqi/article/details/101396817
public class csp_04 {
    public static final long num = (long)1e9;


    public static void add(int type, int commodity, int score, int[][] a) {
        a[type][commodity-1] = score;
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
//        commodity[i][j] 存储第i类第j+1个商品的得分
        int[][] commodity = new int[50][10];
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt() - 1;
            int score = sc.nextInt();
            for (int j = 0; j < m; j++) {
                commodity[j][id] = score;
            }
        }
        int op = sc.nextInt();
        for (int i = 0; i < op; i++) {
            if (sc.nextInt() == 1) {
                commodity[sc.nextInt()][sc.nextInt()-1] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(commodity[i][j]);
            }
            System.out.println();
        }
    }
}
/*
2 3
1 3
2 2
3 1
8
3 100 1 1
1 0 4 3
1 0 5 1
3 10 2 2
3 10 1 1
2 0 1
3 2 1 1
3 1 1 1
 */