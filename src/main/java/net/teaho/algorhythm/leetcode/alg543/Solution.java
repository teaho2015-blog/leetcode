package net.teaho.algorhythm.leetcode.alg543;


import net.teaho.algorhythm.leetcode.common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 * <p/>543. 二叉树的直径
 * <p/>https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=problem-list-v2&envId=2cktkvj
 *
 * <p/>深度优先搜索：就是递归不停找最大的深度
 *
 * <p/>时间复杂度：O(n) 击败99%
 * <p/>空间复杂度：O(1)
 *
 *
 * @author teaho2015@gmail.com
 * @date 2025-04
 */
public class Solution {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = 1;
        depth(root);
        return res - 1;
    }

    public int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int maxL = depth(treeNode.left);
        int maxR = depth(treeNode.right);
        res = Math.max(res, maxL + maxR + 1);
        return Math.max(maxL, maxR) + 1;
    }
}
