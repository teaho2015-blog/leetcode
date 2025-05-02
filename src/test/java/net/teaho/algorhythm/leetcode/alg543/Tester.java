package net.teaho.algorhythm.leetcode.alg543;

import net.teaho.algorhythm.leetcode.common.TreeNode;
import org.junit.Test;

/**
 * @author hetingleong@xiaomi.com
 * @date 2025-05
 */
public class Tester {

    @Test
    public void test() {
        TreeNode root = TreeNode.levelOrderGenerate(new Integer[] {1,2,3,4,5});
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
}
