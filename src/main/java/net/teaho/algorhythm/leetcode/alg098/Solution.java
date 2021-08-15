package net.teaho.algorhythm.leetcode.alg098;

import net.teaho.algorhythm.leetcode.common.TreeNode;

/**
 * <p>98. 验证二叉搜索树
 * <p>https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * <p>思路：二叉树遍历，关键在于确定好临界判断值
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(n) 线程栈空间
 *
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Solution {


    public boolean isValidBST(TreeNode root) {

        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    public boolean check(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }
        if (min >= root.val || root.val >= max) {
            return false;
        }

        return check(root.left, min, root.val) && check(root.right, root.val, max);



    }
}
