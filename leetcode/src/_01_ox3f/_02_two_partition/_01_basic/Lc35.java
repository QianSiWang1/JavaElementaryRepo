package _01_ox3f._02_two_partition._01_basic;

public class Lc35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if(nums[mid]>=target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
