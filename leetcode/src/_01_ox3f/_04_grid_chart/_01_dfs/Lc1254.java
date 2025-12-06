package _01_ox3f._04_grid_chart._01_dfs;

public class Lc1254 {
    class Solution {
        public int closedIsland(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            if (m < 3 || n < 3) return 0;
            for (int i = 0; i < m; i++) {
                // 如果是第一行和最后一行，访问所有格子
                // 如果不是，只访问第一列和最后一列的格子
                int step = i == 0 || i == m - 1 ? 1 : n - 1;
                for (int j = 0; j < n; j += step)
                    dfs(grid, i, j);
            }

            int ans = 0;
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (grid[i][j] == 0) { // 从没有访问过的 0 出发
                        ans++; // 一定是封闭岛屿
                        dfs(grid, i, j);
                    }
                }
            }
            return ans;
        }

        private void dfs(int[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] != 0)
                return;
            grid[x][y] = 1; // 标记 (x,y) 被访问，避免重复访问
            dfs(grid, x - 1, y);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x, y + 1);
        }
    }
}
