package net.teaho.algorhythm.leetcode.alg300longestIncreasingSubsequence;

/**
 * 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * <br/>
 * 动态规划 + 二分查找 Dynamic programming + Dichotomy.<br/>
 * 时间复杂度O(nlogn) <br/>
 * 空间复杂度O(n)   <br/>
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (dp[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            dp[i] = num;
            if (res == j) {
                res ++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        {
            System.out.println(new Solution2().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        }
    }
}
