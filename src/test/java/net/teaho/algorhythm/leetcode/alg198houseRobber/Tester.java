package net.teaho.algorhythm.leetcode.alg198houseRobber;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Tester {

    @Test
    public void test() {
        assertThat(new Solution().rob(new int[] {1,2,3,1}), equalTo(4));
    }
}
