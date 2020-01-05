package 随机一题_leetcode;

public class LeetCode682 {
    /**
     * 创建一个成绩数组，记录每次的得分，最后求和
     * 若是C就把上一个赋值为0
     * @param ops
     * @return
     */
    public static int calPoints(String[] ops) {
        int[] score = new int[ops.length];
        int j = 0;
        for (int i = 0; i < ops.length; i++) {
            char temp = ops[i].charAt(0);
            if (i == 0) {
                score[j] = Integer.parseInt(ops[i]);
                j++;
                continue;
            }
            if (temp == 'C') {
                j--;
                score[j] = 0;
            } else if (temp == 'D') {
                score[j] = score[j - 1] * 2;
                j++;
            } else if (temp == '+') {
                score[j] = score[j - 1] + score[j - 2];
                j++;
            } else {
                score[j] = Integer.parseInt(ops[i]);
                j++;
            }
        }
        int sum = 0;
        for (int i : score) {
            sum += i;
            System.out.print(i + " ");
        }
        return sum;
    }

    public static void main(String[] args) {
//        String[] ops = {"5", "2", "C", "D", "+"};
//        String[] ops = {"5","-2","4","C","D","9","+","+"};
        String[] ops = {"36","28","70","65","C","+","33","-46","84","C"};
        System.out.println(calPoints(ops));
    }
}

/*
5 5 15 30
5
5 7
5 5
5 5 15
5 5 15 30
 */