package net.teaho.algorhythm.leetcode.alg152;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author teaho2015@gmail.com
 * @date 2021-08
 * @since 1.0.0
 */
public class Tester {

    @Test
    public void test() {

        MatcherAssert.assertThat("!", new Solution().maxProduct(new int[]{-1, -2, -9, -6}), Matchers.equalTo(108));

    }
}
