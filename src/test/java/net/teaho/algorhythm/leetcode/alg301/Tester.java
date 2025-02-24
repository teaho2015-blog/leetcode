package net.teaho.algorhythm.leetcode.alg301;

import net.teaho.algorhythm.leetcode.alg301.Solution1;
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
        List<String> list = new Solution1().removeInvalidParentheses("()())()");

        MatcherAssert.assertThat(list, Matchers.equalTo(Arrays.asList("(())()", "()()()")));


    }

}


