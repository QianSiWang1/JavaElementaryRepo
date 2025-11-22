package _01_ox3f.slidewindowandtwopointer.varslidewindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc2799 {
    public static void main(String[] args) {

    }

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int size = set.size();
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for(int right = 0; right < nums.length; right++){
             map.merge(nums[right], 1, Integer::sum);
            if(map.size() == size){
                while(map.size() == size){
                    map.merge(nums[left],-1,Integer::sum);
                    if(map.get(nums[left]) == 0){
                        map.remove(nums[left]);
                    }
                    left++;
                }
            }
            res+=left;
        }
        return res;
    }
}
