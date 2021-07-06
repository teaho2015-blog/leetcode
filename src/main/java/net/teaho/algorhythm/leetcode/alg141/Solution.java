package net.teaho.algorhythm.leetcode.alg141;

import net.teaho.algorhythm.leetcode.common.ListNode;

/**
 * <p>141. 环形链表
 * <p>https://leetcode-cn.com/problems/linked-list-cycle/
 *
 *
 * <p>思路：Floyd判圈算法
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(1)
 *
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 15.56% 的用户
 *
 * @author teaho2015@gmail.com
 * @date 2021-07
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;

        } while (fast != slow);

        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().hasCycle(ListNode.toListNode(new int[]{3, 2, 0, -4})));
    }
}
