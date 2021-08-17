package net.teaho.algorhythm.leetcode.alg104;

import net.teaho.algorhythm.leetcode.common.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author teaho2015@gmail.com
 */
public class Tester {


    @Test
    public void test() {

        TreeNode treeNode = TreeNode.levelOrderGenerate(new Integer[] {3, 9, 20, null, null, 15, 7});
        MatcherAssert.assertThat("!", new Solution().maxDepth(treeNode), Matchers.equalTo(3));

    }
}
