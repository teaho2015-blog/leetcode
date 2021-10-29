package net.teaho.algorhythm.leetcode.alg221maximalSquare;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author teaho2015@gmail.com
 * @date 2021-10
 * @since 1.0.0
 */
public class Tester {

    @Test
    public void test() {

        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        assertThat(new Solution().maximalSquare(matrix), equalTo(4));
    }
}
