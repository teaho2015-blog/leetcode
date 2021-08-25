package net.teaho.algorhythm.leetcode.alg142;

import net.teaho.algorhythm.leetcode.common.ListNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Tester {

    @Test
    public void test() {
        int pos = 1;
        ListNode l = ListNode.toCircleListNode(new int[]{3, 2, 0, -4}, pos);
        ListNode meet = l;
        for (int i = 0; i < pos; i++) {
            meet = meet.next;
        }
        ListNode res = new Solution().detectCycle(l);
        assertThat("!", meet, equalTo(res));
    }
}
