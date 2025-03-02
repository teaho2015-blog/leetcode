package net.teaho.algorhythm.leetcode.alg253;

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
        int rooms = new Solution().minMeetingRooms(new int[][]{new int[]{0,30}, new int[]{5,10}, new int[]{15,20}});

        MatcherAssert.assertThat(rooms, Matchers.equalTo(2));


    }

}


