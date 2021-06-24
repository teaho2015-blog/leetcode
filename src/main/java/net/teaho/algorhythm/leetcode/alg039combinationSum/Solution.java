package net.teaho.algorhythm.leetcode.alg039combinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>39. 组合总和
 * <p>https://leetcode-cn.com/problems/combination-sum/
 *
 * <p>思路：对于这类寻找所有可行解的题，我们都可以尝试用「搜索回溯」的方法来解决。
 * <p>时间复杂度：最差情况O(n*2^n)
 * <p>空间复杂度：O(target)
 *
 */
public class Solution {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> combine = new ArrayList<>();
        backTrack(candidates, res, combine, 0, target);

        return res;

    }

    public void backTrack(int[] candidates, List<List<Integer>> res, List<Integer> combine, int idx, int target) {

        if (idx == candidates.length) {
            return;
        }

        if (target <= 0) {
            res.add(new ArrayList<>(combine));
            return;
        }

        backTrack(candidates, res, combine, idx + 1, target);

        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            backTrack(candidates, res, combine, idx, target - candidates[idx]);
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 5}, 8));
    }
}
