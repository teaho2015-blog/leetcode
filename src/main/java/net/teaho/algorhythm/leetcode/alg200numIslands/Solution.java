package net.teaho.algorhythm.leetcode.alg200numIslands;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 *
 * 解法的遍历思路在这（岛屿问题的统一遍历思路）：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 *
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int numIslands(char[][] grid) {

        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    res++;
                }
            }
        }
        return res;
    }


    void dfs(char[][] grid, int r, int c) {
        // 判断 base case
        if (!inArea(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != '1') {
            return;
        }
        grid[r][c] = 2; // 将格子标记为「已遍历过」

        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
            && 0 <= c && c < grid[0].length;
    }

    public static void main(String[] args) {

        {
            char[][] grid = new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
            };
            System.out.println(new Solution().numIslands(grid));
        }

        {
            char[][] grid = new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}
            };
            System.out.println(new Solution().numIslands(grid));
        }

    }


}
