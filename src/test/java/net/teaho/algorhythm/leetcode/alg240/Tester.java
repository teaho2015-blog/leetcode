package net.teaho.algorhythm.leetcode.alg240;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author teaho2015@gmail.com
 * @date 2021-12
 */
public class Tester {

    @Test
    public void testResult() {

        MatcherAssert.assertThat(true, Matchers.equalTo(new Solution().searchMatrix(new int[][] {
            {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        }, 5)));

        MatcherAssert.assertThat(true, Matchers.equalTo(new Solution().searchMatrix(new int[][] {
                {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}},
            19)));

    }
}
