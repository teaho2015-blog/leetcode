package net.teaho.algorhythm.leetcode.alg034;

import java.util.Arrays;

/**
 * <p>34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * <p>思路：拿到题，一个排序数组的话，那么最粗暴的方式就是遍历一遍，或者左右指针。还有就是二分查找了。
 * <p>时间复杂度：O(log n)
 * <p>空间复杂度：O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = binarySearch(nums, target, false);
        int right = binarySearch(nums, target, true);
        return new int[]{left, right};
    }

    public int binarySearch(int[] nums, int target, boolean bigger) {

        int left = 0, right = nums.length - 1, res = 0;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target || (!bigger && nums[mid] >= target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[right] == target) {
            return right;
        } else if (bigger && right-1 >=0 && nums[right-1] == target) {
            return right-1;

        } else {
            return -1;
        }

    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{}, 0)));

    }
}
