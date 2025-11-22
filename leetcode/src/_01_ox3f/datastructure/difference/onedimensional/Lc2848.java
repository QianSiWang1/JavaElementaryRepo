package _01_ox3f.datastructure.difference.onedimensional;

import java.util.List;

public class Lc2848 {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] sum = new int[101];
        for(List<Integer> cur : nums){
            sum[cur.get(0)]++;
            sum[cur.get(1)]--;
        }
        int res = 0;
        for(int x : sum){
            res+=x==0?0:1;
        }
        return res;
    }
}
