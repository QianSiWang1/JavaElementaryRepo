package ox3f.gridchart.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Lc1926 {
    int[][] directions =  {{1,0},{-1,0},{0,1},{0,-1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int[] poll = queue.poll();
                for(int[] direction :directions){
                    if(poll[0]+direction[0] < 0
                    ||poll[0]+direction[0] >= maze.length
                    ||poll[1]+direction[1] <0
                    ||poll[1]+direction[1] >=maze[0].length) continue;
                    if(maze[poll[0]+direction[0]][poll[1]+direction[1]] == '.'){
                        if(poll[0]+direction[0] == 0 ||poll[1]+direction[1] ==0){
                            return res+1;
                        }
                        queue.add(new int[]{poll[0]+direction[0],poll[1]+direction[1]});
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
