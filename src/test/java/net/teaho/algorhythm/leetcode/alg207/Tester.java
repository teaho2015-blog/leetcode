package net.teaho.algorhythm.leetcode.alg207;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author hetingleong@xiaomi.com
 * @date 2021-09
 */
public class Tester {

    @Test
    public void test() {

        assertThat(new Solution().canFinish(2, new int[][] {{1, 0}}), equalTo(true));
        assertThat(new Solution().canFinish(5, new int[][] {{1, 4}, {2, 4}, {3, 1}, {3, 2}}), equalTo(true));

    }
}
