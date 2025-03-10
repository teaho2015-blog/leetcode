package net.teaho.algorhythm.leetcode.alg322;

import java.util.Arrays;

/**
 *
 * 322. 零钱兑换<p>
 * https://leetcode.cn/problems/coin-change/description/?envType=problem-list-v2&envId=2cktkvj&
 *
 *
 * 动态规划，也可以理解为不停找最大公约数的过程
 *
 * 时间复杂度：O(sn)
 * 空间复杂度：O(n)
 *
 * @author teaho2015@gmail.com
 * @date 2025-03
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i < amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
                }

            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];

    }
}
