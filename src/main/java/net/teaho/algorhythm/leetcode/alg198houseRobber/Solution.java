package net.teaho.algorhythm.leetcode.alg198houseRobber;

/**
 * <p>198. 打家劫舍
 * <p>https://leetcode-cn.com/problems/house-robber/
 *
 * <p>思路：动态规划
 * dp[i] = max(dp[i-1], dp[i-2] + nums[i])
 *
 * <p>边界：dp[0] = nums[0];
 * dp[1] = max（nums[0], nums[1]）
 *
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(n)
 *
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 35.7 MB , 在所有 Java 提交中击败了 62.29% 的用户
 *
 */
public class Solution {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];


    }

}
