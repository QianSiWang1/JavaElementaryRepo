package hot100.commonarray;

/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] temp = {-3,-2,-1};
        System.out.println(maxSubArray(temp));

    }
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
