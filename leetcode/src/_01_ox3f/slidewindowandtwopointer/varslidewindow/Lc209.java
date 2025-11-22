package _01_ox3f.slidewindowandtwopointer.varslidewindow;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class Lc209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int res = nums.length+1;
        int sum = 0;
        for(int right = 0; right< nums.length;right++){
            sum+=nums[right];
            while(sum >= target){
                res = Math.min(res,right - left + 1);
                sum-=nums[left++];
            }
        }
        return res==nums.length+1?0:res;
    }
}
