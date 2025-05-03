package ox3f.gridchart.dfs;

public class Lc200 {
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0 ;j<n;j++){
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid,int x ,int y){
        if(x<0 || x>=grid.length  || y<0||y>=grid[0].length|| grid[x][y] != '1'){
            return;
        }
        grid[x][y] = '0';
        for(int[] d : direction){
            dfs(grid,x + d[0],y + d[1]);
        }
    }
}
