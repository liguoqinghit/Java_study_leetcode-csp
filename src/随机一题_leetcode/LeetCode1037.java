package 随机一题_leetcode;

public class LeetCode1037 {
    public static boolean isBoomerang(int[][] points) {
//        存在相同点
        if ((points[0][0] == points[1][0] && points[0][1] == points[1][1]) ||
                (points[0][0] == points[2][0] && points[0][1] == points[2][1]) ||
                (points[1][0] == points[2][0] && points[1][1] == points[2][1]))
            return false;
//        同x即一条横线
        if (points[0][0] == points[1][0] && points[0][0] == points[2][0])
            return false;
//        两个x同 两个x不同
        if (points[0][0] == points[1][0] && points[0][0] != points[2][0])
            return true;
        if (points[0][0] == points[2][0] && points[0][0] != points[1][0])
            return true;
//        斜率相同的时候
        if (((double)(points[0][1] - points[1][1]) / (points[0][0] - points[1][0])) ==
                ((double)(points[0][1] - points[2][1]) / (points[0][0] - points[2][0]))) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        int[][] point = {{1, 1}, {2, 3}, {3, 2}};
        int[][] point = {{0, 1}, {1, 1}, {3, 3}};
        System.out.println(isBoomerang(point));
    }
}
