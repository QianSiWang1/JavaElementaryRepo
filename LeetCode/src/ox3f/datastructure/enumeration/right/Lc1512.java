package ox3f.datastructure.enumeration.right;

import java.util.HashMap;
import java.util.Map;

public class Lc1512 {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int x : nums){
            int temp = map.getOrDefault(x,0);
            res+=temp;
            map.put(x,temp+1);
        }
        return res;
    }
}
