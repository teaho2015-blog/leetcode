package net.teaho.algorhythm.leetcode.alg162;

/**
 * <p>162. 寻找峰值
 * <p>https://leetcode-cn.com/problems/find-peak-element/
 *
 * <p>思路：二分查找，字节一面
 * <p>时间复杂度：O(log n)
 * <p>空间复杂度：O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;

            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            }

            return left;
        }


    public static void main(String[] args) {

        System.out.println(new Solution().findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution().findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));

    }
}
