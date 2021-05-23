package net.teaho.algorhythm.leetcode.alg103zigzagLevelOrder;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 *
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
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean recordFromLeft = true;
        while (!nodeQueue.isEmpty()) {

            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = nodeQueue.poll();
                if (recordFromLeft) {
                    levelList.addLast(cur.val);
                } else {
                    levelList.addFirst(cur.val);
                }
                if (cur.left != null) {
                    nodeQueue.offer(cur.left);
                }
                if (cur.right != null) {
                    nodeQueue.offer(cur.right);
                }


            }
            recordFromLeft = !recordFromLeft;
            res.add(new LinkedList<>(levelList));
        }
        return res;

    }

    public static void main(String[] args) {
        Random random = new Random();
        int val = 0;
        TreeNode root = new TreeNode(++val);
        LinkedList<TreeNode> tier = new LinkedList<>();
        tier.add(root);
        for (int i = 0; i < 2; i++) {
            LinkedList<TreeNode> curTier = new LinkedList<>();
            while (!tier.isEmpty()) {
                TreeNode cur = tier.pop();
                if (random.nextInt(10) > 2) {
                    cur.left = new TreeNode(++val);
                    curTier.add(cur.left);
                }

                if (random.nextInt(10) > 2) {
                    cur.right = new TreeNode(++val);
                    curTier.add(cur.right);
                }
            }
            tier.addAll(curTier);

        }

        List<List<Integer>> res = new Solution().zigzagLevelOrder(root);
        System.out.println(res);

    }

}
