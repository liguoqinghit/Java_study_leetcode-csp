package 随机一题_leetcode;

public class LeetCode470 extends SolBase {
//    均匀概率。。。
//
    public int ran10() {
        int num = ran7();
        double temp = (double)  num / 7.0 * 10;
        if (temp < 1) temp = 1;
        if (temp > 10) temp = 10;
        return (int)temp;
    }
    public static void main(String[] args) {
        int[] a = {10,4,1,5,10,2,7,1,7,8,7,4,5,8,2,5,4,2,4,2,4,1,10,5,4,5,8,1,8,4,1,8,8,2,8,5,8,4,1,2,2,7,8,4,5,5,7,1,2,7,8,4,4,4,4,8,2,8,8,7,4,2,4,7,7,8,7,5,7,4,8,5,8,1,8,1,1,10,5,1,8,7,7,4,1,7,10,4,1,2,5,5,4,5,2,2,1,4,2,1};
        int temp = 0;
        for (int i : a) temp++;
        System.out.println(temp);
    }
}

class SolBase {
    public int ran7() {
        return (int)(7 * Math.random());
    }
}