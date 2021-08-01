package net.teaho.algorhythm.leetcode.alg079;

/**
 * <p>79. 单词搜索
 * <p>https://leetcode-cn.com/problems/word-search/
 *
 * <p>思路：回溯
 * <p>时间复杂度：O(i*j*word.length)
 * <p>空间复杂度：O(i*j)
 *
 * @author teaho2015@gmail.com
 * @date 2021-07
 */
public class Solution {


    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        boolean[][] visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean flag = check(board, visit, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean check(char[][] board, boolean[][] visit, int i, int j, String word, int k) {
        //情况一 不相同，情况二 校验word结束了，情况三已访问
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (word.length() -1 == k) {
            return true;
        }

        //走相邻
        visit[i][j] = true;
        int[][] diretion = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] ints : diretion) {
            int newI = ints[0] + i, newJ = ints[1] + j;

            if (newI < 0 || newJ < 0 || newI > board.length - 1 || newJ > board[0].length -1 || visit[newI][newJ]) {
                continue;
            }
            boolean check = check(board, visit, newI, newJ, word, k + 1);
            if (check) {
                visit[i][j] = false;
                return true;
            }


        }

        visit[i][j] = false;

        return false;

    }


    public static void main(String[] args) {
//        {
//            char[][] cs = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//            System.out.println(new Solution().exist(cs, "ABCCED"));
//        }

//        {
//            char[][] cs = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//            System.out.println(new Solution().exist(cs, "SEE"));
//        }

        {
            char[][] cs = {{'a'}};
            System.out.println(new Solution().exist(cs, "a"));
        }



    }
}
