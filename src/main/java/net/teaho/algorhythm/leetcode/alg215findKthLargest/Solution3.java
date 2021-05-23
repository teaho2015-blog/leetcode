package net.teaho.algorhythm.leetcode.alg215findKthLargest;

import java.util.Arrays;

/**
 * 暴力解法，快排取第k项
 *
 */
public class Solution3 {


    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k];
    }

    public static void main(String[] args) {
        int result = new Solution().findKthLargest(new int[]{2, 6, 7, 10, 1, 7, 5}, 4);
        System.out.println(result);
    }

}
