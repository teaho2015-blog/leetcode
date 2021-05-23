package net.teaho.algorhythm.leetcode.alg206reverseLinkedList;

/**
 *
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

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


    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 14; i++) {
            ListNode tmp = new ListNode(i);
            node.next = tmp;
            node = tmp;
        }

        printValue(new Solution().reverseList(head));
    }

    private static void printValue(ListNode head) {
        System.out.println("print for object:" + head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


}