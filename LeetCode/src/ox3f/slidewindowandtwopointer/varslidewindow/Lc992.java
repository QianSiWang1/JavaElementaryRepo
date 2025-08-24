package ox3f.slidewindowandtwopointer.varslidewindow;

import java.util.HashMap;
import java.util.Map;

public class Lc992 {
    public static void main(String[] args) {

    }

    public int subArraysWithKDistinct(int[] nums, int k) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        int left1 = 0;
        int left2 = 0;
        int res = 0;
        for(int right = 0;right < nums.length;right++){
            map1.merge(nums[right],1,Integer::sum);
            map2.merge(nums[right],1,Integer::sum);
            while(map1.size()>=k){
                map1.merge(nums[left1],-1,Integer::sum);
                if(map1.get(nums[left1]) == 0){
                    map1.remove(nums[left1]);
                }
                left1++;
            }
            while(map2.size()>=k+1){
                map2.merge(nums[left2],-1,Integer::sum);
                if(map2.get(nums[left2]) == 0){
                    map2.remove(nums[left2]);
                }
                left2++;
            }
            res+=left1-left2;
        }
        return res;
    }
}
