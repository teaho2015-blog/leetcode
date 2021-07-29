package net.teaho.algorhythm.leetcode.alg078;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>78. 子集
 * <p>https://leetcode-cn.com/problems/subsets/
 *
 *
 * <p>思路：回溯，一般这种找所有解的题目都可想想回溯法，推敲是可用二叉树来模拟字符选择情况
 * <p>时间复杂度：O(n*n^2)
 * <p>空间复杂度：O(n)
 *
 * @author teaho2015
 * @since 2021-07
 *
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrace(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void backTrace(int[] nums, int cur, List<Integer> tmp, List<List<Integer>> res) {

        if (cur == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[cur]);
        backTrace(nums, cur + 1, tmp, res);
        tmp.remove(tmp.size() - 1);
        backTrace(nums, cur + 1, tmp, res);

    }


    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }
}
