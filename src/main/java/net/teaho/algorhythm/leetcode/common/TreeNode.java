package net.teaho.algorhythm.leetcode.common;


import java.util.*;
import java.util.function.Supplier;

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


    public static TreeNode levelOrderGenerate(Integer[] arr) {


        Queue<TreeNode> queue = new LinkedList<>();

        Queue<Supplier<Integer>> itemArr = new LinkedList<>();
        for (Integer integer : arr) {
            itemArr.offer(() -> integer);
        }

        TreeNode rootNode = new TreeNode(itemArr.poll().get());
        queue.add(rootNode);

        while (!queue.isEmpty() && !itemArr.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size && !itemArr.isEmpty(); i++) {
                TreeNode node = queue.poll();
                Supplier<Integer> leftVal = itemArr.poll();
                if (leftVal.get() != null) {
                    node.left = new TreeNode(leftVal.get());
                    queue.offer(node.left);
                }

                if (!itemArr.isEmpty()) {
                    Supplier<Integer> rightVal = itemArr.poll();
                    if (rightVal.get() != null) {

                        node.right = new TreeNode(rightVal.get());
                        queue.offer(node.right);
                    }
                }
            }
        }


        return rootNode;
    }


    public static boolean equalsTree(TreeNode root1, TreeNode root2) {

        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        } else if (root1 == null) {
            return true;
        }

        return root1.val == root2.val && equalsTree(root1.left, root2.left) && equalsTree(root1.right, root2.right);

    }
    //    public static void main(String[] args) {
//        printTree(levelOrderGenerate(new Integer[]{5, 1, 4, null, null, 3, 6}));
//    }

}