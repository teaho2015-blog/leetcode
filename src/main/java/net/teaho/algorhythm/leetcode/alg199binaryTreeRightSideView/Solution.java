package net.teaho.algorhythm.leetcode.alg199binaryTreeRightSideView;

import net.teaho.algorhythm.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static net.teaho.algorhythm.leetcode.common.TreeNode.randomTree;

/**
 * 199. 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 *
 *
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.addLast(root);
        while (!nodeQueue.isEmpty()) {
            res.add(nodeQueue.getLast().val);
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = nodeQueue.poll();
                if (cur.left != null) {
                    nodeQueue.offer(cur.left);
                }
                if (cur.right != null) {
                    nodeQueue.offer(cur.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().rightSideView(randomTree()));
    }

}
