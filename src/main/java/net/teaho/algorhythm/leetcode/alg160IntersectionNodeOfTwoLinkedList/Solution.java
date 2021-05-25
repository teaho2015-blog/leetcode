package net.teaho.algorhythm.leetcode.alg160IntersectionNodeOfTwoLinkedList;

import net.teaho.algorhythm.leetcode.common.ListNode;

import static net.teaho.algorhythm.leetcode.common.ListNode.concat;
import static net.teaho.algorhythm.leetcode.common.ListNode.toListNode;

/**
 * 160. 相交链表 intersection-of-two-linked-lists
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * <p>
 * <p>
 * 算法思想：a + c + b + c = b + c + a + c （c为重复部分）
 * <p>
 * 时间复杂度O(m+n)
 * 空间复杂度O(1)
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //指针
        ListNode head1 = headA;
        ListNode head2 = headB;
        while (head1 != head2) {
            if (head1 != null) {
                head1 = head1.next;
            } else {
                head1 = headB;
            }

            if (head2 != null) {
                head2 = head2.next;
            } else {
                head2 = headA;
            }
        }
        return head1;

    }


    public static void main(String[] args) {

        int[] listA = new int[]{4, 1};
        int[] listB = new int[]{5, 0, 1};
        int[] listC = new int[]{8, 4, 5};
        ListNode listNodeC = toListNode(listC);
        ListNode listNodeA = concat(toListNode(listA), listNodeC);
        ListNode listNodeB = concat(toListNode(listB), listNodeC);
        ListNode.printListNodeValue(new Solution().getIntersectionNode(listNodeA, listNodeB));
    }

}
