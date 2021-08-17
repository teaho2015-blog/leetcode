package net.teaho.algorhythm.leetcode.alg104;

import net.teaho.algorhythm.leetcode.common.TreeNode;

/**
 * <p>104. 二叉树的最大深度
 * <p>https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * <p>思路：深度优先遍历
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(depth) depth为树深度的栈
 *
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Solution {

    int max = 0;

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(left, right) + 1;

        return max;
    }
}
