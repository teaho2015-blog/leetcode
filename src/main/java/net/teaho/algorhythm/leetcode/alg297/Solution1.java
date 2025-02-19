package net.teaho.algorhythm.leetcode.alg297;

import net.teaho.algorhythm.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 297. 二叉树的序列化与反序列化<p/>
 * https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/?envType=problem-list-v2&envId=2cktkvj
 *
 * 题目不难，用深度优先
 *
 *
 * @author teaho2015@gmail.com
 * @date 2025-02
 */
public class Solution1 {

    private static final String N = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        rserialize(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] strs = data.split(",");
        List<String> stringList = new LinkedList<>(Arrays.asList(strs));
        return rdeserialize(stringList);
    }


    private void rserialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(N).append(",");
            return;
        }
        sb.append(root.val).append(",");
        rserialize(root.left, sb);
        rserialize(root.right, sb);
    }

    private TreeNode rdeserialize(List<String> list) {

        if (list.get(0).equals(N)) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = rdeserialize(list);
        root.right = rdeserialize(list);

        return root;
    }


}
