package net.teaho.algorhythm.leetcode.alg234;

import net.teaho.algorhythm.leetcode.common.ListNode;

/**
 * <p>234. 回文链表
 * <p>https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * <p>思路：快慢指针
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：1
 *
 *
 * 执行用时： 3 ms , 在所有 Java 提交中击败了 99.92% 的用户
 * 内存消耗： 48.1 MB , 在所有 Java 提交中击败了 92.20% 的用户
 *
 * @author hetingleong@xiaomi.com
 * @date 2021-10
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }

        ListNode l = head;
        ListNode r = head;
        ListNode pre = head;
        ListNode tmp = null;

        while (r != null && r.next != null) {
            pre = l;
            l = l.next;
            r = r.next.next;
            pre.next = tmp;
            tmp = pre;
        }

        if (r != null) {
            l = l.next;
        }


        while (pre.next != null && l.next != null) {
            if (l.val != pre.val) {
                return false;
            }
            l = l.next;
            pre = pre.next;
        }

        if (pre.val != l.val) {
            return false;
        }

        if (pre.next == null && l.next == null) {
            return true;
        }

        return false;

    }


}
