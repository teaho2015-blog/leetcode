package net.teaho.algorhythm.leetcode.alg226;

import net.teaho.algorhythm.leetcode.common.TreeNode;

/**
 * <p>226. 翻转二叉树
 * <p>https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * <p>思路：递归
 * <p>时间复杂度：O(N)
 * <p>空间复杂度：O(N)
 *
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 35.6 MB , 在所有 Java 提交中击败了 95.80% 的用户
 *
 * @author hetingleong@xiaomi.com
 * @date 2021-09
 */
public class Solution {


    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}
