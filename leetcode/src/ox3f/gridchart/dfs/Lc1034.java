package ox3f.gridchart.dfs;

public class Lc1034 {
    class Solution {
        int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        public int[][] colorBorder(int[][] grid, int row, int col, int color) {
            int target = grid[row][col];
            int m = grid.length;
            int n = grid[0].length;
            int[][] visited = new int[m][n];
            dfs(grid, row, col, target, visited, color);
            for(int i = 0;i<m;i++){
                for(int j = 0;j<n;j++){
                    if(i > 0 &&  i<m-1 && j>0 && j < n-1 && visited[i][j]==1){
                        if(visited[i-1][j]==1
                                &&visited[i+1][j]==1
                                &&visited[i][j-1]==1
                                &&visited[i][j+1]==1){
                            grid[i][j]=target;
                        }
                    }
                }
            }
            return grid;
        }

        public void dfs(int[][] grid, int x, int y, int target, int[][] visited, int color) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] == 1 || grid[x][y] != target) {
                return;
            }
            grid[x][y] = color;
            visited[x][y] = 1;
            for (int[] d : direction) {
                dfs(grid, x + d[0], y + d[1], target, visited, color);
            }
        }
    }
}
