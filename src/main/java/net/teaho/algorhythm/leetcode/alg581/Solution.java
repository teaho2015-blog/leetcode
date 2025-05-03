package net.teaho.algorhythm.leetcode.alg581;

/**
 * <p/>581. 最短无序连续子数组
 * <p/>https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/description/?envType=problem-list-v2&envId=2cktkvj
 *
 * <p/>循环找最大最小
 *
 * <p/>时间复杂度：O(n) 80%
 * <p/>空间复杂度：O(1)
 *
 *
 *
 * @author teaho2015<at/>xiaomi.com
 * @date 2025-05
 */
public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int min = nums[nums.length - 1];
        int max = nums[0];
        int begin = 0;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                end = i;
            }
            if (nums[nums.length - i - 1] <= min) {
                min = nums[nums.length - i - 1];
            } else {
                begin = nums.length - i - 1;
            }

        }

        return end - begin + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(new int[]{1, 2, 3, 4, 5}));
    }

}
