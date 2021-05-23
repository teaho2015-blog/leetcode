package net.teaho.algorhythm.leetcode.alg023mergeKLists;

import java.util.PriorityQueue;

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
 * 大根堆  O(kn×logk)
 * 空间复杂度：这里用了优先队列，优先队列中的元素不超过 kk 个，故渐进空间复杂度为 O(k)
 */
public class Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>((x, y)->x.val-y.val);
        for(ListNode node : lists){
            if(node!=null){
                q.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!q.isEmpty()){
            tail.next = q.poll();
            tail = tail.next;
            if (tail.next != null){
                q.add(tail.next);
            }
        }
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

        printListNodeValue(new Solution2().mergeKLists(listNodes));
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