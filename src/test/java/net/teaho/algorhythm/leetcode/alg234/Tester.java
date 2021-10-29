package net.teaho.algorhythm.leetcode.alg234;

import net.teaho.algorhythm.leetcode.common.ListNode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import static net.teaho.algorhythm.leetcode.common.ListNode.toListNode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author hetingleong@xiaomi.com
 * @date 2021-10
 */
public class Tester {

    @Test
    public void test() {

        assertThat(new Solution().isPalindrome(toListNode(new int[] {1, 2, 2, 1})), equalTo(true));
        assertThat(new Solution().isPalindrome(toListNode(new int[] {1, 2})), equalTo(false));
        assertThat(new Solution().isPalindrome(toListNode(new int[] {1, 0, 1})), equalTo(true));

    }
}
