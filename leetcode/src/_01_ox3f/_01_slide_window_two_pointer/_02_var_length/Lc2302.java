package _01_ox3f._01_slide_window_two_pointer._02_var_length;

public class Lc2302 {
    public long countSubarrays(int[] nums, long k) {
        int left = 0;
        long res = 0;
        long  points = 0;
        for(int right = 0;right < nums.length;right++){
            points+=nums[right];
            while(points*(right - left + 1) >= k){
                points-=nums[left++];
            }
            res+=right-left+1;
        }
        return res;
    }
}
