package ox3f.gridchart.dfs;

public class Lc1034 {
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int target = grid[row][col];
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0 ;j<n;j++){
                if(grid[i][j] == target){
                    dfs(grid,i,j,target);
                }
            }
        }
        return grid;
    }
    public void dfs(int[][] grid,int x ,int y,int target){
        if(x<0 || x>=grid.length  || y<0||y>=grid[0].length|| grid[x][y] != target){
            return ;
        }
        grid[x][y] = 0;
        for(int[] d : direction){
            dfs(grid,x + d[0],y + d[1],target);
        }
    }
}
