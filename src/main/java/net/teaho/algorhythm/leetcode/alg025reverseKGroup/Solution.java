package net.teaho.algorhythm.leetcode.alg025reverseKGroup;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * <p>
 * 难点在于返回每个部分被修改的头节点，新建一个头节点的前置节点 o(n)
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode resultNode = head;
        int flag = 0;
        ListNode start = head;
        ListNode end = head;
        ListNode pre = null;
        while (end != null) {
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
//            ListNode cursorLast = start;
            ListNode nextLoopStart = end.next;
            end.next = null;
            ListNode reversedStart = reverse(start);
            if (flag == 0) {
                resultNode = reversedStart;
                flag = 1;
            }
            if (pre != null) {
                pre.next = reversedStart;
            }
            pre = start;
            start.next = nextLoopStart;
            start = nextLoopStart;
            end = nextLoopStart;
        }


        return resultNode;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
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
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 14; i++) {
            ListNode tmp = new ListNode(i);
            node.next = tmp;
            node = tmp;
        }
        printValue(head);

        ListNode resultListHead = new Solution().reverseKGroup(head, 3);

        printValue(resultListHead);
    }

    private static void printValue(ListNode head) {
        System.out.println("print for object:" + head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


}