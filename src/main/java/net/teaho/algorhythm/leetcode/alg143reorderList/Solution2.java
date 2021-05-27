package net.teaho.algorhythm.leetcode.alg143reorderList;

import net.teaho.algorhythm.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 *
 * 时间复杂度O(N)
 * 空间~O(1)
 *
 * 1ms
 */
public class Solution2 {
    // 找中点+反转后半部分+合并前后两部分
    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)return;

        // 1. 找中点，让slow指向中点，或左中点位置
        ListNode slow = head, fast = head.next;
        while (fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 断开中点，反转后半部分
        ListNode head2 = null, next = slow.next;
        slow.next = null;
        slow = next;
        while(slow != null) {
            next = slow.next;
            slow.next = head2;
            head2 = slow;
            slow = next;
        }

        // 3. 合并链表head和head2
        ListNode curr = head;
        ListNode curr2 = head2;
        while(curr != null && curr2!=null) {
            next = curr.next;
            curr.next = curr2;
            curr2 = curr2.next;
            curr.next.next = next;
            curr = next;
        }
    }


    public static void main(String[] args) {
        ListNode node = ListNode.toListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        new Solution2().reorderList(node);
        ListNode.printListNodeValue(node);
    }
}
