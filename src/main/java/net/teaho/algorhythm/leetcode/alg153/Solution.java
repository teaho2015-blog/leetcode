package net.teaho.algorhythm.leetcode.alg153;

/**
 *
 * <p>153. 寻找旋转排序数组中的最小值
 * <p>https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * <p>思路：二分查找
 * <p>时间复杂度：O(log n)
 * <p>空间复杂度：O(1)
 *
 * <p>capcut面试题
 *
 * @author teaho2015@gmail.com
 * @date 2025-06
 */
public class Solution {

    public int findMin(int[] nums) {


        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{3,4,5,1,2}));
    }


}
