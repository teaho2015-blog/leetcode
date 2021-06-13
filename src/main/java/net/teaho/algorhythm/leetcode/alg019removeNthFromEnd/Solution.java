package net.teaho.algorhythm.leetcode.alg019removeNthFromEnd;

import net.teaho.algorhythm.leetcode.common.ListNode;

import static net.teaho.algorhythm.leetcode.common.ListNode.printListInOneLine;
import static net.teaho.algorhythm.leetcode.common.ListNode.toListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * <p>https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 *
 *  <p>小米国际事业部一面的面试题，当时一开始想到加一个数组（或栈）去做，后来和面试官交流，侥幸想到双指针的解法。
 *  现在整理输出如下。
 *
 * <p>执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
 * <p>内存消耗：36.3 MB, 在所有 Java 提交中击败了72.68%的用户
 *
 *
 * <p>时间复杂度 O(n)
 * <p>空间复杂度 O(1)
 *
 * @author teaho2015@gmail.com
 * @date 2021-06
 */
public class Solution {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 1 && head.next == null) {
            return null;
        }
        ListNode pre = head;
        ListNode next = head;
        int i = 0;
        while (next.next != null) {
            if (i < n) {
                next = next.next;
                i++;
            } else {
                pre = pre.next;
                next = next.next;
            }
        }

        if (i == n - 1) {
            return head.next;
        } else if (i < n) {
            return head;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static void main(String[] args) {
        {
            int[] arr = new int[]{1, 2, 3, 4, 5};
            printListInOneLine(new Solution().removeNthFromEnd(toListNode(arr), 2));
        }

        {
            int[] arr = new int[]{1};
            printListInOneLine(new Solution().removeNthFromEnd(toListNode(arr), 1));
        }

        {
            int[] arr = new int[]{1, 2};
            printListInOneLine(new Solution().removeNthFromEnd(toListNode(arr), 1));
        }

        {
            int[] arr = new int[]{1, 2};
            printListInOneLine(new Solution().removeNthFromEnd(toListNode(arr), 2));
        }
    }
}
