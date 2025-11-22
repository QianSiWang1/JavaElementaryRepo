package hot100myself.graphtheory;

public class NumberOfIslands {
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid,int i,int j){
        if(i<0 || i>=grid.length ||  j<0 || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';
        for(int[] arr : directions){
            dfs(grid,i+arr[0],j+arr[1]);
        }
    }
}
