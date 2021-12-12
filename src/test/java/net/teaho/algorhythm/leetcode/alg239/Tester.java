package net.teaho.algorhythm.leetcode.alg239;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.arrayContaining;

/**
 * @author teaho2015@gmail.com
 * @date 2021-12
 * @since 1.0.0
 */
public class Tester {

    @Test
    public void test() {
        MatcherAssert.assertThat(Arrays.equals(new Solution().maxSlidingWindow(new int[]{7, 2, 4}, 2),
            new int[]{7, 4}), Matchers.equalTo(true));
    }
}
