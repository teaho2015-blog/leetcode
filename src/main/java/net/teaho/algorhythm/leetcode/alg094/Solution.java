package net.teaho.algorhythm.leetcode.alg094;

import net.teaho.algorhythm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>94. 二叉树的中序遍历
 * <p>https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * <p>思路：种树遍历
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(n) 取决于递归栈深度，最差O(n)
 *
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    public void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorderTraversal(root.left, res);
            res.add(root.val);
            inorderTraversal(root.right, res);
        }
    }
}
