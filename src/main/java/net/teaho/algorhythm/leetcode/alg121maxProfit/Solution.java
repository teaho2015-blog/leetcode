package net.teaho.algorhythm.leetcode.alg121maxProfit;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * 维护一个最低股价变量，同时维护当前收益o(n)
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int money = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > money) {
                money = prices[i] - min;
            }
        }
        return money;
    }

    public static void main(String[] args) {
        {
            int[] prices = new int[]{7, 1, 5, 3, 6, 4};
            System.out.println(new Solution().maxProfit(prices));
        }
        {

            int[] prices = new int[]{7, 6, 4, 3, 1};
            System.out.println(new Solution().maxProfit(prices));
        }

    }
}
