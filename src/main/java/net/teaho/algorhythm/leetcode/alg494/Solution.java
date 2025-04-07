package net.teaho.algorhythm.leetcode.alg494;

import java.util.Arrays;

/**
 *
 * 494. 目标和<p>
 * https://leetcode.cn/problems/target-sum/?envType=problem-list-v2&envId=2cktkvj&<br/>
 *
 *
 *回溯 并在回溯过程中维护count
 *
 * 时间复杂度：O(2^n) <br/>
 * 空间复杂度： O(n)
 *
 * @author teaho2015@gmail.com
 * @date 2025-03
 */
public class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        trackBack(nums, target, 0, 0);

        return count;
    }

    public void trackBack(int[] nums, int target, int index, int sum) {
        if (index + 1 == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            trackBack(nums, target, index+1, sum - nums[index]);
            trackBack(nums, target, index+1, sum + nums[index]);
        }
    }
}
