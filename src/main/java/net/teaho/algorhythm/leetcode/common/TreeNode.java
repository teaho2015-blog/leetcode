package net.teaho.algorhythm.leetcode.common;


import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode randomTree() {

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
        return root;
    }

    public static void printTree(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            System.out.println("Tree is empty!");
        }

        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.addLast(root);
        while (!nodeQueue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = nodeQueue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    nodeQueue.offer(cur.left);
                }
                if (cur.right != null) {
                    nodeQueue.offer(cur.right);
                }
            }
            res.add(list);
        }
        System.out.println(res);
    }

}