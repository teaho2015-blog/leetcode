package net.teaho.algorhythm.leetcode.alg070climbStairs;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * 动态规划 dp[i]表示到达第i阶的方法总数dp[i]=dp[i−1]+dp[i−2]  <br/>
 * 时间复杂度o(n)
 *
 * @author teaho2015
 */
public class Solution {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(8));
    }
}
