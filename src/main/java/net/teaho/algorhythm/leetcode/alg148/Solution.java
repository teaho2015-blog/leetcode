package net.teaho.algorhythm.leetcode.alg148;

import net.teaho.algorhythm.leetcode.common.ListNode;

/**
 * <p>148. 排序链表
 * <p>https://leetcode-cn.com/problems/sort-list/
 *
 * <p>思路：自底向上的归并排序
 * <p>时间复杂度：O(NlgN)
 * <p>空间复杂度：O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        //求len
        int len = 0;
        ListNode node = head;
        for (; node != null; node = node.next, ++len) {
        }

        ListNode res = new ListNode(-1);
        res.next = head;
        //size为子集长度
        for (int sz = 1; sz < len; sz += sz) {
            ListNode pre = res;
            ListNode cur = res.next;
            while (cur != null) {
                ListNode head1, head2;
                head1 = cur;
                for (int i = 0; i < sz - 1 && cur.next != null; i++) {
                    cur = cur.next;
                }
                head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 0; i < sz - 1 && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }

                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                cur = next;

                ListNode merged = merge(head1, head2);
                pre.next = merged;
                while (pre.next != null) {
                    pre = pre.next;
                }


            }


        }

        return res.next;


    }


    public ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else if (a.val < b.val) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }


    }

    public static void main(String[] args) {
        ListNode.printListInOneLine(new Solution().sortList(ListNode.toListNode(new int[]{-1, 5, 3, 4, 0})));

    }
}
