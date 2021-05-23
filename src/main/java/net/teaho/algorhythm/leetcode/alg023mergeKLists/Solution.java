package net.teaho.algorhythm.leetcode.alg023mergeKLists;

import java.util.stream.IntStream;

/**
 * 23. 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *

 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[3];
//        int [1,4,5],[1,3,4],[2,6];
        {
            int[] ints = new int[]{1, 4, 5};
            listNodes[0] = toListNode(ints);
        }
        {
            int[] ints = new int[]{1, 3, 4};
            listNodes[1] = toListNode(ints);

        }
        {
            int[] ints = new int[]{2, 6};
            listNodes[2] = toListNode(ints);
        }

        printListNodeValue(new Solution().mergeKLists(listNodes));
    }

    private static ListNode toListNode(int[] ints) {
        ListNode head = new ListNode(ints[0]);
        ListNode node = head;
        for (int i = 1; i < ints.length; i++) {
            ListNode tmp = new ListNode(ints[i]);
            node.next = tmp;
            node = tmp;
        }
        return head;
    }

    private static void printListNodeValue(ListNode head) {
        System.out.println("print for object:" + head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}