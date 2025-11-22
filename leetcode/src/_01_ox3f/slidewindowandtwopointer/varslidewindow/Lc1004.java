package _01_ox3f.slidewindowandtwopointer.varslidewindow;

/**
 *
 */
public class Lc1004 {
    public int longestOnes(int[] nums, int k) {
        int count0 = 0;
        int left = 0;
        int res = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right] == 0){
                count0++;
            }
            while(count0 > k){
                count0-= nums[left] == 0 ? 1 : 0;
                left++;
            }
            res = Math.max(res,right - left + 1);
        }
        return res;
    }
}
