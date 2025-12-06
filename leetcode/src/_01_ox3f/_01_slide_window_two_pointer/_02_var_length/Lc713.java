package _01_ox3f._01_slide_window_two_pointer._02_var_length;

/**
 * 713. 乘积小于 K 的子数组
 */
public class Lc713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int left = 0;
        int res = 0;
        int prod  = 1;
        for(int right = 0;right < nums.length;right++){
            prod  *= nums[right];
            while(prod  >= k){
                prod  /= nums[left++];
            }
            res+= right -left +1;
        }
        return res;
    }
}
