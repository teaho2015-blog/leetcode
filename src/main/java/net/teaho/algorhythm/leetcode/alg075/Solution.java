package net.teaho.algorhythm.leetcode.alg075;

import java.util.Arrays;

/**
 *
 * <p>75. 颜色分类
 * <p>https://leetcode-cn.com/problems/sort-colors/
 *
 * <p>思路: 手写快排
 * <p>时间复杂度：O(NlgN)
 * <p>空间复杂度：O(1)
 *
 * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * <p>内存消耗： 36.8 MB , 在所有 Java 提交中击败了 76.65% 的用户
 *
 * @author teaho2015@gmail.com
 * @date 2021-07
 */
public class Solution {

    public void sortColors(int[] nums) {

        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int lf, int rt) {
        if (lf >= rt) {
            return;
        }
        int idx = partition(nums, lf, rt);
        sort(nums, lf, idx - 1);
        sort(nums, idx + 1, rt);
    }

    public int partition(int[] nums, int lf, int rt) {
        int i = lf, j = rt + 1;
        int cursor = nums[lf];
        while (true) {
            while (nums[++i] < cursor) if (i == rt) break;
            while (nums[--j] > cursor) if (j == lf) break;

            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lf, j);

        return j;


    }

    public void swap(int[] nums, int idx1, int idx2) {
        if (idx1 == idx2) {
            return;
        }
        nums[idx1] = nums[idx1] + nums[idx2];
        nums[idx2] = nums[idx1] - nums[idx2];
        nums[idx1] = nums[idx1] - nums[idx2];
    }


    public static void main(String[] args) {

        {
            int[] arr = new int[]{2, 0, 2, 1, 1, 0};
            new Solution().sortColors(arr);
            System.out.println(Arrays.toString(arr));
        }

        {
            int[] arr = new int[]{2, 0, 1};
            new Solution().sortColors(arr);
            System.out.println(Arrays.toString(arr));
        }

        {
            int[] arr = new int[]{1, 2};
            new Solution().sortColors(arr);
            System.out.println(Arrays.toString(arr));
        }
    }
}
