package net.teaho.algorhythm.leetcode.algbytedanceSortOddEvenList;

import net.teaho.algorhythm.leetcode.common.ListNode;

/**
 * 字节跳动高频题——排序奇升偶降链表
 * <p>
 * https://zhuanlan.zhihu.com/p/311113031
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzkxNDI1MTA1MA==&mid=2247484398&idx=1&sn=2734c206cea6db8bbf3bf01b8b4a334a&source=41#wechat_redirect
 */
public class Solution {


    public ListNode sortOddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddCursor = odd;
        ListNode evenCursor = even;
        int flag = 0;
        while (head != null) {
            if (flag == 0) {
                oddCursor.next = head;
                oddCursor = oddCursor.next;
            }else {
                evenCursor.next = head;
                evenCursor = evenCursor.next;
            }
            flag ^= 1;
            head = head.next;
        }
        oddCursor.next = null;
        evenCursor.next = null;
        //翻转
        even = reverseList(even.next);
        odd = odd.next;

        return mergeTwoLists(odd, even);


    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode res = new ListNode(0);
        ListNode cursor = res;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cursor.next = head1;
                head1 = head1.next;
            } else {
                cursor.next = head2;
                head2 = head2.next;
            }
            cursor = cursor.next;
        }
        cursor.next = head1 == null ? head2: head1;

        return res.next;
    }


    public static void main(String[] args) {
        {
            ListNode.printListNodeValue(new Solution().sortOddEvenList(
                ListNode.toListNode(new int[]{1,8,3,6,5,4,7,2})));

        }
    }
}
