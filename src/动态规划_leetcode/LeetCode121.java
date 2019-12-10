package 动态规划_leetcode;

/*
该题相关的其他题目的解析
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
 */


public class LeetCode121 {
    public static int maxProfit(int[] prices) {
        int price_min = Integer.MAX_VALUE;
        int profit_max = 0;
        for (int i = 0; i < prices.length; i++) {
//            用的时间少
            if (prices[i] < price_min) {
                price_min = prices[i];
            } else if (prices[i] - price_min > profit_max) {
                profit_max = prices[i] - price_min;
            }
//            用的时间多
//            price_min = Math.min(price_min, prices[i]);
//            profit_max = Math.max(profit_max, prices[i] - price_min);
        }
        return profit_max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
