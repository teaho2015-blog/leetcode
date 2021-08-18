package net.teaho.algorhythm.leetcode.alg114;

import net.teaho.algorhythm.leetcode.common.TreeNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static net.teaho.algorhythm.leetcode.common.TreeNode.*;

/**
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Tester {


    @Test
    public void test() {
        {
            TreeNode root = levelOrderGenerate(new Integer[]{1, 2, 5, 3, 4, null, 6});
            new Solution().flatten(root);

            MatcherAssert.assertThat("!", equalsTree(root, levelOrderGenerate(new Integer[]{1, null, 2, null, 3, null, 4, null, 5, null, 6})),
                Matchers.equalTo(true));


        }

        {
            TreeNode root = levelOrderGenerate(new Integer[]{});
            new Solution().flatten(root);

            MatcherAssert.assertThat("!", equalsTree(root, levelOrderGenerate(new Integer[]{})),
                Matchers.equalTo(true));

        }

        {
            TreeNode root = levelOrderGenerate(new Integer[]{1,null,2,3});
            new Solution().flatten(root);

            MatcherAssert.assertThat("!", equalsTree(root, levelOrderGenerate(new Integer[]{1,null,2, null,3})),
                Matchers.equalTo(true));

        }

    }
}
