package net.teaho.algorhythm.leetcode.alg238;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author hetingleong@xiaomi.com
 * @date 2021-10
 */
public class Tester {

    @Test
    public void test() {

        assertThat(new Solution().productExceptSelf(new int[] {1, 2, 3, 4}), equalTo(new int[] {24, 12, 8, 6}));
//        assertThat(new Solution().productExceptSelf(new int[] {1, 2, 3, 4}), equalTo(new int[] {24, 12, 8, 6}));

    }
}
