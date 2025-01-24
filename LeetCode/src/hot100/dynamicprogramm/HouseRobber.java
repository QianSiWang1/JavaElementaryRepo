package hot100.dynamicprogramm;

/**
 * 198. 打家劫舍
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
        }
        return f[n - 1];
    }
    public static int rob1(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 2];
        for (int i = 0; i < n; ++i) {
            f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
        }
        return f[n + 1];
    }

}
