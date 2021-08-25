package net.teaho.algorhythm.leetcode.alg142;

import net.teaho.algorhythm.leetcode.common.ListNode;

/**
 * <p>142. 环形链表 II
 * <p>https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * <p>思路：Floyd判圈算法
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2021-08
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while(fast != slow);

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
