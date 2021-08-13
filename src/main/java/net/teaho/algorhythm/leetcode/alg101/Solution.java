package net.teaho.algorhythm.leetcode.alg101;

import net.teaho.algorhythm.leetcode.common.TreeNode;

/**
 *
 * <p>101. 对称二叉树
 * <p>https://leetcode-cn.com/problems/symmetric-tree/
 *
 * <p>思路：递归
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(n) 线程栈空间
 *
 * @author teaho2015@gmail.com
 * @date 2021-07
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {

        return check(root, root);
    }

    public boolean check(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);

    }


}
