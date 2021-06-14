package net.teaho.algorhythm.leetcode.alg002addTwoNumbers;

import net.teaho.algorhythm.leetcode.common.ListNode;

/**
 * 2. 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * 解题思路：
 * 用变量记录进位，然后按位相加。
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了99.20%的用户
 *
 * 时间：O(max(l1, l2)) 两链表最长的一个
 * 空间：O(max(l1, l2)) 两链表最长的一个
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;
            tail  = tail.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
        {
            ListNode result = new Solution().addTwoNumbers(
                ListNode.toListNode(new int[]{2,4,3}),
                ListNode.toListNode(new int[]{5,6,4})
            );
            ListNode.printListInOneLine(result);
        }

        {
            ListNode result = new Solution().addTwoNumbers(
                ListNode.toListNode(new int[]{0}),
                ListNode.toListNode(new int[]{0})
            );
            ListNode.printListInOneLine(result);
        }

        {
            ListNode result = new Solution().addTwoNumbers(
                ListNode.toListNode(new int[]{9,9,9,9,9,9,9}),
                ListNode.toListNode(new int[]{9,9,9,9})
            );
            ListNode.printListInOneLine(result);
        }




    }
}
