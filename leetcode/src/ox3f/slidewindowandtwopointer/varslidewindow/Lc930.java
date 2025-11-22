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

    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            int n = nums.length;
            int left1 = 0, left2 = 0, right = 0;
            int sum1 = 0, sum2 = 0;
            int ret = 0;
            while (right < n) {
                sum1 += nums[right];
                while (left1 <= right && sum1 > goal) {
                    sum1 -= nums[left1];
                    left1++;
                }
                sum2 += nums[right];
                while (left2 <= right && sum2 >= goal) {
                    sum2 -= nums[left2];
                    left2++;
                }
                ret += left2 - left1;
                right++;
            }
            return ret;
        }
    }

}
