package ox3f.slidewindowandtwopointer.varslidewindow;

import java.util.Arrays;
import java.util.List;

public class Lc2962 {
    public static void main(String[] args) {

    }
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int left = 0;
        long res = 0;
        int count = 0;
        for(int right = 0;right < nums.length;right++){
            if(nums[right] == max){
                count++;
            }
            while(count>=k){
                count-= nums[left++] == max ? 1:0;
            }
            res+=left;
        }
        return res;

    }

}
