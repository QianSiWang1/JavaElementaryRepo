package ox3f.slidewindowandtwopointer.varslidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Lc1695 {

    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int res = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            max+=nums[right];
            int temp = nums[right];
            Integer merge = map.merge(temp, 1, Integer::sum);
            while(map.get(temp) > 1){
                Integer merge1 = map.merge(nums[left], -1, Integer::sum);
                if(merge1 == 0){
                    map.remove(nums[left]);
                }
                max-=nums[left];
                left++;
            }
            res = Math.max(res,max);
        }
        return res;
    }
}
