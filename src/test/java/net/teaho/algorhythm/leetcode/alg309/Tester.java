package net.teaho.algorhythm.leetcode.alg309;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author teaho2015@gmail.com
 * @date 2025-03
 */
public class Tester {

    @Test
    public void test() {
        int integer = new Solution().maxProfit(new int[] {1,2,3,0,2});

        MatcherAssert.assertThat(integer, Matchers.equalTo(3));
    }

}


