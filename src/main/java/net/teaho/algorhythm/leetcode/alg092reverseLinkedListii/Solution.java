package net.teaho.algorhythm.leetcode.alg092reverseLinkedListii;

import net.teaho.algorhythm.leetcode.common.ListNode;

/**
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * 头插法
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 *
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cursor = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = cursor.next;
            cursor.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode.printListNodeValue(new Solution()
                .reverseBetween(ListNode.toListNode(new int[]{1, 2, 3, 4, 5}), 2, 4));
        ListNode.printListNodeValue(new Solution()
            .reverseBetween(ListNode.toListNode(new int[]{5}), 1, 1));
    }
}
