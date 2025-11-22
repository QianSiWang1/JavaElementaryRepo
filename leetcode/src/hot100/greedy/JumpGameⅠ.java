package hot100.greedy;

/**
 * 55. 跳跃游戏
 */
public class JumpGameⅠ {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++){
            if (i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
