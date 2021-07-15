package net.teaho.algorhythm.leetcode.alg55jumpGame;

/**
 * <p>55. 跳跃游戏
 * <p>https://leetcode-cn.com/problems/jump-game/
 *
 *
 * <p>思路：https://leetcode-cn.com/problems/jump-game/solution/55-by-ikaruga/
 * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
 * <p>时间复杂度：O(n)
 * <p>空间复杂度：O(1)
 *
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 92.37% 的用户
 * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 87.17% 的用户
 *
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int rightmost = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //判断是否能到达当前位置
            if (i > rightmost) return false;
            if (rightmost >= len - 1) {
                return true;
            }

            rightmost = Math.max(rightmost, i + nums[i]);
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
    }


}
