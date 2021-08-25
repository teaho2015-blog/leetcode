package net.teaho.algorhythm.leetcode.common;

import org.jcp.xml.dsig.internal.dom.ApacheOctetStreamData;

/**
 * 链表节点
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode toListNode(int[] ints) {
        if (ints == null || ints.length == 0) {
            return null;
        }
        ListNode head = new ListNode(ints[0]);
        ListNode node = head;
        for (int i = 1; i < ints.length; i++) {
            ListNode tmp = new ListNode(ints[i]);
            node.next = tmp;
            node = tmp;
        }
        return head;
    }

    public static ListNode toCircleListNode(int[] ints, int pos) {
        if (ints == null || ints.length == 0) {
            return null;
        }
        ListNode head = new ListNode(ints[0]);
        ListNode node = head;
        for (int i = 1; i < ints.length; i++) {
            ListNode tmp = new ListNode(ints[i]);
            node.next = tmp;
            node = tmp;
        }

        //环形链表
        if (pos > -1) {
            ListNode tail = head;
            ListNode posNode = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            for (int i = 0; i < pos; i++) {
                posNode = posNode.next;
            }
            tail.next = posNode;
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

    public static void printListInOneLine(ListNode head) {
        System.out.println("print for object:" + head);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println("");
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

