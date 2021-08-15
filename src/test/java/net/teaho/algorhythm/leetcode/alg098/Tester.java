package net.teaho.algorhythm.leetcode.alg098;

import net.teaho.algorhythm.leetcode.common.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 *
 *
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Tester {

    @Test
    public void test() {
        {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(1);
            root.right = new TreeNode(5);
            root.right.left = new TreeNode(4);
            assertThat("!", new Solution().isValidBST(root), Matchers.equalTo(true));

        }

        {
            TreeNode root = TreeNode.levelOrderGenerate(new Integer[]{5, 4, 6, null, null, 3, 7});
            assertThat("!", new Solution().isValidBST(root), Matchers.equalTo(false));
        }
    }
}
