package CSP_201604;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class csp_04 {
    public static class Node {
        int i = 0, j = 0, time = 0;
        Node(int i1, int j1, int time1) {
            i = i1;
            j = j1;
            time = time1;
        }
    }

    /**
     * 广度优先遍历
     * 第三维 305 300 + 2  2个存储起始时间 3个多余的
     * 300是因为从(0,0)到(n,m)最多需要200步，而a,b<=100(危险时间最多为100)
     * 即当最大危险时刻过去后，再从(0,0)到(n,m)，共300
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<Node> queue = new LinkedList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[][][] dt = new int[n][m][305];
        for (int i = 0; i < t; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int a = sc.nextInt();
            int b = sc.nextInt();
            dt[r][c][0] = a;
            dt[r][c][1] = b;
        }
        queue.add(new Node(0, 0, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.i == n-1 && node.j == m-1) {
                System.out.println(node.time);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ni = node.i + dir[i][0];
                int nj = node.j + dir[i][1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < m &&
                    dt[ni][nj][node.time+3] == 0 && node.time+1 < 300 &&
                    (node.time + 1 < dt[ni][nj][0] || node.time + 1 > dt[ni][nj][1])) {
                    queue.add(new Node(ni, nj, node.time+1));
                    dt[ni][nj][node.time+3] = 1;
                }
            }
        }

    }
}

/*
样例输入
3 3 3
2 1 1 1
1 3 2 10
2 2 2 10
样例输出
6
 */