package net.teaho.algorhythm.leetcode.alg236lowestCommonAncestor;

import net.teaho.algorhythm.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Random;

import static net.teaho.algorhythm.leetcode.common.TreeNode.randomTree;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * LCA二叉树的最近公共祖先（递归）o(n)
 *
 * 时间复杂度：O(N)，其中 N 是二叉树的节点数。二叉树的所有节点有且只会被访问一次，因此时间复杂度为 O(N)。
 *
 * 空间复杂度：O(N)，其中 N 是二叉树的节点数。递归调用的栈深度取决于二叉树的高度，二叉树最坏情况下为一条链，此时高度为 N，因此空间复杂度为O(N)。
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode lfNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rtNode = lowestCommonAncestor(root.right, p, q);
        if (lfNode != null && rtNode != null) {
            return root;
        } else if (lfNode == null) {
            return rtNode;
        } else {
            return lfNode;
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode = randomTree();
        new Solution().lowestCommonAncestor(treeNode, treeNode, treeNode);
    }
}
