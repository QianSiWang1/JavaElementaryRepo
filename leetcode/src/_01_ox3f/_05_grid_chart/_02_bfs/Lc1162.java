package _01_ox3f._05_grid_chart._02_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Lc1162 {
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public int maxDistance(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int[] poll = queue.poll();
                int m = poll[0];
                int n = poll[1];
                for(int[] direction : directions){
                    int x = direction[0];
                    int y = direction[1];
                    if(m+x<0 || m+x >=grid.length || n+y < 0||n+y>=grid[0].length || grid[m+x][n+y] == 1){
                        continue;
                    }
                    grid[m+x][n+y] = 1;
                    queue.add(new int[]{m+x,n+y});
                }
            }

            res++;
        }
        return res;
    }
}
