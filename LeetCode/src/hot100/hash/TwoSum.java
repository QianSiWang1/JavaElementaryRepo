package hot100.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * number 1
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (dict.containsKey(target - nums[i])) {
                return new int[]{i, dict.get(target - nums[i])};
            } else {
                dict.put(nums[i], i);
            }
        }
        return new int[0];
    }
}

