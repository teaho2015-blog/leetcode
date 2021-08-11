package net.teaho.algorhythm.leetcode.alg094;

import net.teaho.algorhythm.leetcode.common.TreeNode;
import org.hamcrest.Matchers;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 */
public class Tester {


    @Test
    public void testSolution() {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        assertThat("Not same!", Arrays.asList(1, 3, 2), Matchers.equalTo(new Solution().inorderTraversal(root)));

    }
}
