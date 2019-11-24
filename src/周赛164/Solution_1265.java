package 周赛164;

public class Solution_1265 {
    /**
     * 1.计算相邻的两点的x,y的差值，取绝对值
     * 2.假设能按对角线走，x--且y--，直到x或y的值为0
     * 3.再加上x和y，就是剩下的水平或垂直距离（x和y其中一个为0）
     * 4.遍历相加得到结果
     * @param points
     * @return
     */
    public static int minTimeToVisitAllPoints(int[][] points) {
        if (points.length < 2) {
            return 0;
        }
        int time = 0;
        int x = points[0][0], y = points[0][1];
        for (int i = 1; i < points.length; i++) {
            x = Math.abs(points[i][0] - x);
            y = Math.abs(points[i][1] - y);
            while (x > 0 && y > 0) {
                time++;
                x--;
                y--;
            }
            time += (x + y);
            x = points[i][0];
            y = points[i][1];
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(minTimeToVisitAllPoints(points));

    }
}
