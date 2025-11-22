package _01_ox3f.datastructure.enumeration.right;

import java.util.HashMap;
import java.util.Map;

public class Lc2001 {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double,Integer> map = new HashMap<>();
        int res = 0;
        for(int[] arr : rectangles){
            double x = (double) arr[0] / (double) arr[1];
            int temp = map.getOrDefault(x,0);
            res+=temp;
            map.put(x,temp+1);
        }
        return res;
    }
}
