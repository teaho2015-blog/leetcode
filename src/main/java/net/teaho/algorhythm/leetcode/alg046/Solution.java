package net.teaho.algorhythm.leetcode.alg046;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>46. 全排列
 * <p>https://leetcode-cn.com/problems/permutations/solution/
 *
 * <p>思路：回溯法
 * <p>时间复杂度：O(n*n!)
 * <p>空间复杂度：O(n)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        backTrack(nums, res, new ArrayList<>(nums.length), nums.length);
        return res;
    }

    public void backTrack(int[] nums, List<List<Integer>> res, List<Integer> combine, int size) {

        if (combine.size() == size) {
            res.add(new ArrayList<>(combine));
            return;
        }

        for (int i = 0; i < size; i++) {
            if (combine.contains(nums[i])) {
                continue;
            }
            combine.add(nums[i]);
            backTrack(nums, res, combine, size);
            combine.remove(combine.size() - 1);

        }

    }


    public static void main(String[] args) {

        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
        System.out.println(new Solution().permute(new int[]{0, 1}));
        System.out.println(new Solution().permute(new int[]{1}));
    }
}
