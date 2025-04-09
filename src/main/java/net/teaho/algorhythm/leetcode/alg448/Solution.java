package net.teaho.algorhythm.leetcode.alg448;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字<p/>
 *
 * 题目要求不使用额外空间
 *
 *  将数组当成hash表，原地修改<br/>
 *
 * 时间复杂度：O(n) <br/>
 * 空间复杂度： O(1)
 *
 * @author teaho2015<at/>gmail.com
 * @date 2025-04
 */
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for (int num : nums) {
            int x = (num - 1) % n;
            if (nums[x] <= n) {
                nums[x] += n;
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) {
                res.add(i);
            }
        }
        return res;

    }
}
