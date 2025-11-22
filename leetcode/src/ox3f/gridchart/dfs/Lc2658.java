package ox3f.gridchart.dfs;

public class Lc2658 {
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public int findMaxFish(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0 ;j<n;j++){
                if(grid[i][j] != 0){
                    res = Math.max(res,dfs(grid,i,j));
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid,int x ,int y){
        if(x<0 || x>=grid.length  || y<0||y>=grid[0].length|| grid[x][y] == 0){
            return 0;
        }
        int res =  grid[x][y];
        grid[x][y] = 0;
        for(int[] d : direction){
            res += dfs(grid,x + d[0],y + d[1]);
        }
        return res;
    }
}
