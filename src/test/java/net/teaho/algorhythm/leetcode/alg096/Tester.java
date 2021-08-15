package net.teaho.algorhythm.leetcode.alg096;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Tester {

    @Test
    public void test() {

        assertThat("!", new Solution().numTrees(3), equalTo(5));

    }

}
