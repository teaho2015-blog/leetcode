package net.teaho.algorhythm.leetcode.alg102binarytreeLevelOrderTraversal;

import net.teaho.algorhythm.leetcode.common.TreeNode;

import java.util.*;

/**
 * <p> 102. 二叉树的层序遍历
 * <p> https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 *
 * <p> 小米国际事业部二面的手写题，当下想到了用队列来做，其实可以发现一个规律像Leetcode上二叉树相关的题什么二叉树层序头尾遍历，侧面视图等都可以用队列或双向队列
 * 等数据接口来解答。
 *
 * <p> 执行用时： 1 ms , 在所有 Java 提交中击败了 94.96% 的用户
 * <p> 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 71.31% 的用户
 *
 * <p> 时间复杂度：O(n)
 * <p> 空间复杂度：O(n)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.add(root);
        }

        while(!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                l.add(node.val);
            }
            res.add(l);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().levelOrder(TreeNode.randomTree()));
        System.out.println(new Solution().levelOrder(TreeNode.randomTree()));
        System.out.println(new Solution().levelOrder(TreeNode.randomTree()));
    }
}
