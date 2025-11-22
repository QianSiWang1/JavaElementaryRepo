package _01_ox3f.slidewindowandtwopointer.varslidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 2958. 最多 K 个重复元素的最长子数组
 */
public class Lc2958 {

    public int maxSubarrayLength(int[] nums, int k){
        int left = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            int temp = nums[right];
            map.merge(temp, 1, Integer::sum);
            while(map.get(temp) > k){
                Integer merge1 = map.merge(nums[left], -1, Integer::sum);
                if(merge1 == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res,right - left + 1);
        }
        return res;
    }

}
