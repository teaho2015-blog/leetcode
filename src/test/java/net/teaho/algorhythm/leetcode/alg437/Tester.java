package net.teaho.algorhythm.leetcode.alg437;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import net.teaho.algorhythm.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * @author teaho2015@gmail.com
 * @date 2025-11
 */
public class Tester {

    @Test
    public void test() {
            
        int integer = new Solution().pathSum(TreeNode.levelOrderGenerate(new Integer[] {10,5,-3,3,2,null,11,3,-2,null,1}), 8);
        System.out.println(integer);
        MatcherAssert.assertThat(integer, Matchers.equalTo(3));
    }

}


