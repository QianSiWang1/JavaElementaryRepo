package ox3f.slidewindowandtwopointer.varslidewindow;

import java.util.HashMap;
import java.util.Map;

public class Lc930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            sum+=nums[i];
            if(map.containsKey(sum-goal)){
                res+=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
