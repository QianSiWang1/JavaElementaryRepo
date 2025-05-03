package ox3f.gridchart.dfs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class View1619 {
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public int[] pondSizes(int[][] land) {
        List<Integer> res = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0 ;j<n;j++){
                if(land[i][j] == 0){
                   int area =  dfs(land,i,j);
                    res.add(area);
                }
            }
        }
        Collections.sort(res);
        int[] array = res.stream()
                .mapToInt(Integer::intValue) // 转为 IntStream
                .toArray();
        return array;
    }
    public int dfs(int[][] grid,int x ,int y){
        if(x<0 || x>=grid.length  || y<0||y>=grid[0].length|| grid[x][y] != 0){
            return 0;
        }
        grid[x][y] = 1;
        int res = 1;
        for(int[] d : direction){
            res += dfs(grid,x + d[0],y + d[1]);
        }
        return res;
    }
}
