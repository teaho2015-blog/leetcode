package net.teaho.algorhythm.leetcode.alg101;

import net.teaho.algorhythm.leetcode.common.TreeNode;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author teaho2015@gmail.com
 * @date 2021-07
 */
public class Tester {


    @Test
    public void test() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        assertThat("!", new Solution().isSymmetric(root), Matchers.equalTo(true));
    }
}
