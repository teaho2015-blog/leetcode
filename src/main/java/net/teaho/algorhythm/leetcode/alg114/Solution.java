package net.teaho.algorhythm.leetcode.alg114;

import net.teaho.algorhythm.leetcode.common.TreeNode;

/**
 * <p>114. 二叉树展开为链表
 * <p>https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * <p>思路：找前驱节点
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(1)
 *
 *
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Solution {


    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;


        }
    }
}
