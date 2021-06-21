package net.teaho.algorhythm.leetcode.alg023mergeKLists;

import net.teaho.algorhythm.leetcode.common.ListNode;

import static net.teaho.algorhythm.leetcode.common.ListNode.printListNodeValue;
import static net.teaho.algorhythm.leetcode.common.ListNode.toListNode;

/**
 * <p>23. 合并K个升序链表
 * <p>https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * <p> 二分归并
 * <p> 时间复杂度：O(kn*logK)
 * <p> 空间复杂度：O(logK)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution3 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {

        if (left == right) {
            return lists[left];
        }

        int mid = (left + right) / 2;
        ListNode l = merge(lists, left, mid);
        ListNode r = merge(lists, mid + 1, right);
        return mergeTwoLists(l, r);
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

        printListNodeValue(new Solution3().mergeKLists(listNodes));
    }
}
