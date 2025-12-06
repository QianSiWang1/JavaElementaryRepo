package _01_ox3f._01_slide_window_two_pointer._02_var_length;

/**
 * 1658. 将 x 减到 0 的最小操作数
 */
public class Lc1658 {
    public static void main(String[] args) {
        int[]nums = {3,2,20,1,1,3};
        System.out.println(minOperations(nums,10));
    }
    public static int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target < 0) {
            return -1; // 全部移除也无法满足要求
        }

        int n = nums.length;
        int ans = -1;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > target) {
                sum -= nums[left];
                left++; // 缩小子数组长度
            }
            if (sum == target) {
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans < 0 ? -1 : n - ans;
    }
}
