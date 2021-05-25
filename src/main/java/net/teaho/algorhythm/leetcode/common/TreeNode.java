package net.teaho.algorhythm.leetcode.common;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

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

}