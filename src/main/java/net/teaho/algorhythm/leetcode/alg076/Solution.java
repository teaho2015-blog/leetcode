package net.teaho.algorhythm.leetcode.alg076;

/**
 * <p>76. 最小覆盖子串
 * <p>https://leetcode-cn.com/problems/minimum-window-substring/
 *
 * <p>思路：滑动窗口
 * <p>时间复杂度：O(2*s + t)
 * <p>空间复杂度：O(C) C为字符集大小
 *
 */
public class Solution {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int sLen = s.length();
        int tLen = t.length();

        int[] need = new int[128];
        for (int i = 0; i < tLen; i++) {
            need[t.charAt(i)]++;
        }

        //lf是当前左边界，rt是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int lf = 0, rt = 0, size = Integer.MAX_VALUE, start = 0, count = tLen;

        while (rt < sLen) {
            char c = s.charAt(rt);
            if (need[c] > 0) {
                count--;
            }
            need[c]--;

            if (count == 0) {
                //增加lf
                while(true) {
                    char lc = s.charAt(lf);
                    if (need[lc] == 0) {
                        break;
                    }
                    need[lc]++;
                    lf ++;
                }

                if (rt - lf + 1 < size) {
                    size = rt - lf + 1;
                    start = lf;
                }

                need[s.charAt(lf)]++;
                lf++;
                count++;

            }

            rt++;
        }

        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);

    }


    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
