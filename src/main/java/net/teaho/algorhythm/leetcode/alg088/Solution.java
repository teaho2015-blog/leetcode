package net.teaho.algorhythm.leetcode.alg088;

/**
 *
 * 88. 合并两个有序数组
 * <p/>https://leetcode.cn/problems/merge-sorted-array/description/
 *
 *
 * 逆向双指针
 *
 * <p/>时间复杂度：O(m+n)
 * <p/>空间复杂度：O(1)
 *
 * @author teaho2015<at/>gmail.com
 * @date 2025-02
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) {
                cur = nums2[p2--];
            } else if (p2 < 0) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

}
