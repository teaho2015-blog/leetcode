package net.teaho.algorhythm.leetcode.common;

/**
 * 链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode toListNode(int[] ints) {
        ListNode head = new ListNode(ints[0]);
        ListNode node = head;
        for (int i = 1; i < ints.length; i++) {
            ListNode tmp = new ListNode(ints[i]);
            node.next = tmp;
            node = tmp;
        }
        return head;
    }

    public static void printListNodeValue(ListNode head) {
        System.out.println("print for object:" + head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode concat(ListNode headA, ListNode headB) {
        ListNode head = headA;
        if (headA == null) {
            return headB;
        } else if (headB == null) {
            return headA;
        }
        while (headA.next != null) {
            headA = headA.next;
        }
        headA.next = headB;
        return head;
    }
}

