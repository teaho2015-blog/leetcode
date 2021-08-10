package net.teaho.algorhythm.leetcode.alg085;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Tester {


    @Test
    public void testSolution() {

        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        assertThat(6, Matchers.equalTo(new Solution().maximalRectangle(matrix)));
    }
}
