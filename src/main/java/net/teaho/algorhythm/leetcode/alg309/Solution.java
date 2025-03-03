package net.teaho.algorhythm.leetcode.alg309;

/**
 *
 * 309. 最佳买卖股票时机含冷冻期<p>
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/?envType=problem-list-v2&envId=2cktkvj
 *
 *
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author teaho2015@gmail.com
 * @date 2025-03
 */
public class Solution {

    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][] s = new int[len][3];
        s[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            s[i][0] = Math.max(s[i-1][0], s[i-1][2] - prices[i]);
            s[i][1] = s[i-1][0] + prices[i];
            s[i][2] = Math.max(s[i - 1][1], s[i - 1][2]);


        }

        return Math.max(s[len-1][1], s[len-1][2]);
    }
}
