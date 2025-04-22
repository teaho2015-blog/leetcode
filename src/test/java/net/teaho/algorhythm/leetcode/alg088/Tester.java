package net.teaho.algorhythm.leetcode.alg088;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 *
 * @author teaho2015@gmail.com
 */
public class Tester {

    @Test
    public void test() {
        int[] m = new int[] {1,2,3,0,0,0};
        int[] n = new int[] {2,5,6};

        new Solution().merge(m, 3, n, 3);
        MatcherAssert.assertThat(new int[]{1,2,2,3,5,6}, Matchers.equalTo(m));

    }

}
