package net.teaho.algorhythm.leetcode.alg124binaryTreeMaximumPathSum;

import net.teaho.algorhythm.leetcode.common.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-ikaruga/
 *
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 */
public class Solution {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归左右子树的最大值，负数直接舍弃
        int lfMax = Math.max(0, dfs(root.left));
        int rfMax = Math.max(0,dfs(root.right));
        max = Math.max(max, lfMax + root.val + rfMax);
        return root.val + Math.max(lfMax, rfMax);
    }

    public static void main(String[] args) {

        System.out.println(new Solution().maxPathSum(TreeNode.randomTree()));

        {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            System.out.println(new Solution().maxPathSum(root));
        }

    }

}
