package 随机一题_leetcode;

public class LeetCode307 {
    private int[] n;

    public LeetCode307(int[] nums) {
        this.n = nums;
    }
    public void update(int i, int val) {
        n[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (int a = i; a <= j; a++) {
            sum += n[a];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        LeetCode307 obj = new LeetCode307(nums);
        System.out.println(obj.sumRange(0, 1));
        obj.update(1, 5);
        System.out.println(obj.sumRange(0, 1));
    }
}
