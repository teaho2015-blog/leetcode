package net.teaho.algorhythm.leetcode.alg128;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Tester {

    @Test
    public void test() {

        assertThat("!", new Solution().longestConsecutive(new int[] {100,4,200,1,3,2}), Matchers.equalTo(4));
        assertThat("!", new Solution().longestConsecutive(new int[] {}), Matchers.equalTo(0));
        assertThat("!", new Solution().longestConsecutive(new int[] {1}), Matchers.equalTo(1));
    }
}
