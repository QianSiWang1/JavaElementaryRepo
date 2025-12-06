package _01_ox3f._01_slide_window_two_pointer._01_fixed_length;

import java.util.HashMap;
import java.util.Map;

/**
 * 2461. 长度为 K 子数组中的最大和
 * 给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
 *
 * 子数组的长度是 k，且
 * 子数组中的所有元素 各不相同 。
 * 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
 *
 * 子数组 是数组中一段连续非空的元素序列。
 */
public class Lc2461 {
    public static void main(String[] args) {

    }
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                map.merge(nums[i], 1, Integer::sum);
                sum += nums[i];
            }
            //入
            map.merge(nums[i], 1, Integer::sum);
            sum += nums[i];
            //变
            if(map.size() == k){
                res = Math.max(res, sum);
            }
            //出
            map.merge(nums[i - k + 1], -1, Integer::sum);
            if(map.get(nums[i - k + 1]) == 0){
                map.remove(nums[i - k + 1]);
            }
            sum -= nums[i - k + 1];
        }
        return res;
    }
}
