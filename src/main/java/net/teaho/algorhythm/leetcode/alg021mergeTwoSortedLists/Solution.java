package net.teaho.algorhythm.leetcode.alg021mergeTwoSortedLists;

import net.teaho.algorhythm.leetcode.common.ListNode;

import static net.teaho.algorhythm.leetcode.common.ListNode.toListNode;

/**
 * <p>21. 合并两个有序链表
 * <p>https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * <p>思路：递归
 *
 * <p>时间复杂度：O(m+n)
 * <p>空间复杂度：O(1)
 *
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 37.6 MB , 在所有 Java 提交中击败了 89.16% 的用户
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {

        ListNode.printListInOneLine(new Solution().mergeTwoLists(toListNode(new int[] {1,2,4}), toListNode(new int[] {1,3,4})));
        ListNode.printListInOneLine(new Solution().mergeTwoLists(toListNode(new int[] {}), toListNode(new int[] {})));
        ListNode.printListInOneLine(new Solution().mergeTwoLists(toListNode(new int[] {}), toListNode(new int[] {0})));
    }
}
