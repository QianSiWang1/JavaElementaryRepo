package daily;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right<nums.length){
            if(map.getOrDefault(nums[right],0)>=2){
                right++;
            }
            else{
                nums[left] = nums[right];
                map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            }
        }
        return left+1;
    }
}
