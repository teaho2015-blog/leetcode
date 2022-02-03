package net.teaho.algorhythm.leetcode.alg279;

/**
 *
 * <p>279. 完全平方数
 * <p>https://leetcode-cn.com/problems/perfect-squares/
 *
 *
 * <p>思路：动态规划
 * https://leetcode-cn.com/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/
 *
 * <p>时间复杂度：O(n∗sqrt(n))
 * <p>空间复杂度：O(n)
 *
 * @author teaho2015@gmail.com
 * @date 2022-01
 */
public class Solution {


    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j ] + 1);
            }
        }

        return dp[n];

    }
}
