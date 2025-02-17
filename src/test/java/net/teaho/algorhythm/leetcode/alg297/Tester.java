package net.teaho.algorhythm.leetcode.alg297;

import net.teaho.algorhythm.leetcode.common.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author teaho2015@gmail.com
 * @date 2025-02
 */
public class Tester {

    @Test
    public void test() {

        TreeNode root = TreeNode.randomTree();
        MatcherAssert.assertThat(true, Matchers.equalTo(
            TreeNode.equalsTree(root, new Solution1().deserialize(new Solution1().serialize(root)))));

    }

}


