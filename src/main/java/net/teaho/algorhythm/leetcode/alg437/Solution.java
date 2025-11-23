package net.teaho.algorhythm.leetcode.alg437;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import net.teaho.algorhythm.leetcode.common.TreeNode;

/**
 *
 * 437. 路径总和 III<p>
 * https://leetcode.cn/problems/path-sum-iii/description/?envType=problem-list-v2&envId=2cktkvj&
 *
 * 
 * 前缀和 + 回溯
 * 
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author teaho2015@gmail.com
 * @date 2025-03
 */
public class Solution {

    int result = 0;
    Map<Long, Integer> prefixSumCount = new HashMap<>();
    int targetSum;
    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        prefixSumCount.put(0L, 1);
        dfs(root, 0L);
        return result;
    }

    public void dfs(TreeNode root, long currentSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        result += prefixSumCount.getOrDefault(currentSum - targetSum, 0);
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        dfs(root.left, currentSum);
        dfs(root.right, currentSum);
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
    }

}
