package net.teaho.algorhythm.leetcode.alg139;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author teaho2015@gmail.com
 * @date 2021-08
 * @since 1.0.0
 */
public class Tester {


    @Test
    public void test() {
        assertThat("!", new Solution().wordBreak("leetcode", Arrays.asList("leet", "code")), equalTo(true));

    }
}
