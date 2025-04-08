package net.teaho.algorhythm.leetcode.alg461;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author teaho2015@gmail.com
 * @date 2025-03
 */
public class Tester {

    @Test
    public void test() {
        int integer = new Solution().hammingDistance(1, 4);

        MatcherAssert.assertThat(integer, Matchers.equalTo(2));
    }

}


