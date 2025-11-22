package ox3f.twopartition.findmin;

import java.util.Arrays;

public class Lc1283 {
    class Solution {
        public int smallestDivisor(int[] nums, int threshold) {
            int left = 1;
            int right = Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);
            while (left <= right){
                int mid = left + (right - left)/2;
                if(check(nums,mid,threshold)){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean check(int[] nums, int mid, int threshold) {
            int sum = 0;
            for (int num : nums) {
                sum+= num/mid;
            }
            return sum <= threshold;
        }
    }
}
