package net.teaho.algorhythm.leetcode.alg303;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author teaho2015@gmail.com
 * @date 2025-02
 */
public class Tester {

    @Test
    public void test() {
        int range = new NumArray(new int[] {-2, 0, 3, -5, 2, -1}).sumRange(0, 2);

        MatcherAssert.assertThat(range, Matchers.equalTo(1));


    }

}


