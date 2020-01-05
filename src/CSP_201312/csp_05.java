package CSP_201312;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class csp_05 {
    static int[][] a = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        char[][] c = new char[n][m];
        boolean[][] vis = new boolean[n][m];
        Node start = null, end = null;
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                c[i][j] = s.charAt(j);
                if (c[i][j] == 'S') start = new Node(i, j);
                if (c[i][j] == 'T') end = new Node(i, j);
            }
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(start);
        vis[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (c[node.x][node.y] == '+' || c[node.x][node.y] == 'S' ||
                    c[node.x][node.y] == 'T') {
                for (int i = 0; i < 4; i++) {
                    search(c, vis, (Queue<Node>) q, node, i);
                }
            } else if (c[node.x][node.y] == '-') {
                for (int i = 2; i < 4; i++) {
                    search(c, vis, (Queue<Node>) q, node, i);
                }
            } else if (c[node.x][node.y] == '|') {
                for (int i = 0; i < 2; i++) {
                    search(c, vis, (Queue<Node>) q, node, i);
                }
            } else if (c[node.x][node.y] == '.') {
                search(c, vis, (Queue<Node>) q, node, 0);
            }
        }
        if (!vis[end.x][end.y]) {
            System.out.println("I'm stuck!");
            return;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] && c[i][j] != 'T' && c[i][j] != 'S' && c[i][j] != '#') {
                    if (!bfs(new Node(i, j), new boolean[n][m], c)) result++;
                }
            }
        }
        System.out.println(result);
    }

    private static void search(char[][] c, boolean[][] vis, Queue<Node> q, Node node, int i) {
        int x = node.x + a[i][0];
        int y = node.y + a[i][1];
        if (x >= 0 && x < n && y >= 0 && y < m &&
                c[x][y] != '#' && !vis[x][y]) {
            vis[x][y] = true;
            q.add(new Node(x, y));
        }
    }

    public static boolean bfs(Node start, boolean[][] vis, char[][] c) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(start);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (c[node.x][node.y] == '+') {
                for (int i = 0; i < 4; i++) {
                    search(c, vis, (Queue<Node>) q, node, i);
                }
            } else if (c[node.x][node.y] == '-') {
                for (int i = 2; i < 4; i++) {
                    search(c, vis, (Queue<Node>) q, node, i);
                }
            } else if (c[node.x][node.y] == '|') {
                for (int i = 0; i < 2; i++) {
                    search(c, vis, (Queue<Node>) q, node, i);
                }
            } else if (c[node.x][node.y] == '.') {
                search(c, vis, (Queue<Node>) q, node, 0);
            } else if (c[node.x][node.y] == 'S' || c[node.x][node.y] == 'T') {
                return true;
            }
        }
        return false;
    }
}

class Node {
    public int x, y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/*
样例输入
5 5
--+-+
..|#.
..|##
S-+-T
####.
样例输出
2
 */