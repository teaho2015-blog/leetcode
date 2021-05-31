package net.teaho.algorhythm.leetcode.alg300longestIncreasingSubsequence;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * <br/>
 * 动态规划 <br/>
 * 时间复杂度O(n*n) <br/>
 * 空间复杂度O(n)   <br/>
 */
public class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    public static void main(String[] args) {
        {
            System.out.println(new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        }

    }
}
