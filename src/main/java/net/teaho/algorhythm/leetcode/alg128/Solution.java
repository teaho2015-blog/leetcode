package net.teaho.algorhythm.leetcode.alg128;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>128. 最长连续序列
 * <p>https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 * <p>思路：哈希表。无可避免要找数组中是否存在相邻元素，所以用哈希表缩短查找事件（或者先用排序，不过排序复杂度更高）
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(n)
 *
 * <p>执行用时： 13 ms , 在所有 Java 提交中击败了 83.91% 的用户
 * <p>内存消耗： 53.2 MB , 在所有 Java 提交中击败了 59.62% 的用户
 *
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>(1<<4);
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int y = 1;
                while (set.contains(num + y)) {
                    ++y;
                }
                res = Math.max(y, res);

            }

        }

        return res;
    }






}
