package net.teaho.algorhythm.leetcode.alg143reorderList;

import net.teaho.algorhythm.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 *
 * 时间复杂度O(N)
 * 空间~O(N)
 *
 * 4ms
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> listNodes = new ArrayList<>();

        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        int i = 0, j = listNodes.size() - 1;
        while (i < j) {
            listNodes.get(i).next = listNodes.get(j);
            i++;
            if (i == j) {
                break;
            }
            listNodes.get(j).next = listNodes.get(i);
            j--;
        }
        listNodes.get(i).next = null;
    }


    public static void main(String[] args) {
        ListNode node = ListNode.toListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        new Solution().reorderList(node);
        ListNode.printListNodeValue(node);
    }
}
