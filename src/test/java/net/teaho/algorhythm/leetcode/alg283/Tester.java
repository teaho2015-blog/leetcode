package net.teaho.algorhythm.leetcode.alg283;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author hetingleong@xiaomi.com
 * @date 2021-12
 */
public class Tester {

    @Test
    public void test() {
        int[] arr = {0, 1, 0, 3, 12};

        new Solution().moveZeroes(arr);
        MatcherAssert.assertThat(arr, Matchers.equalTo(new int[] {1, 3, 12, 0, 0}));

    }

}


