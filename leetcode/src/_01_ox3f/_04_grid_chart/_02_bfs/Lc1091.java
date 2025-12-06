package _01_ox3f._04_grid_chart._02_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Lc1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0});
        grid[0][0] = 1;
        int res = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                res++;
                int[] poll = queue.poll();
                int m = poll[0];
                int n = poll[1];

                for(int x = -1 ;x<=1;x++){
                    for (int y = -1;y<=1;y++){
                        if(m+x < 0 || m + x>=grid.length || n+y<0 || n+y>=grid[0].length || grid[m+x][n+y]==1) continue;
                        if(m+x == grid.length - 1 && n+y == grid[0].length -1) return res;
                        grid[m+x][n+y] = 1;
                        queue.add(new int[]{m+x,n+y});
                    }
                }
            }
        }
        return -1;
    }


}
