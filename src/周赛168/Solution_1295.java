package 周赛168;

public class Solution_1295 {
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int temp = 1;
            while (num / 10 != 0) {
                num /= 10;
                temp++;
            }
            if (temp % 2 == 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] nums = {12,345,2,6,7896};
        int[] nums = {555, 901, 482, 1111};
        System.out.println(findNumbers(nums));
    }
}
