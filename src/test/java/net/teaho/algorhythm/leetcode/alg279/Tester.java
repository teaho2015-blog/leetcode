package net.teaho.algorhythm.leetcode.alg279;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author hetingleong@xiaomi.com
 * @date 2022-02
 */
public class Tester {

    @Test
    public void test() {
        MatcherAssert.assertThat(new Solution().numSquares(12), Matchers.equalTo(3));

    }
}
