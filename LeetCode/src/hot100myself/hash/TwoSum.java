package hot100myself.hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        //[2,7,11,15] target=9
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> dict = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            if(dict.containsKey(target-nums[i])){
                return new int[]{i,dict.get(target-nums[i])};
            }else{
                dict.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
