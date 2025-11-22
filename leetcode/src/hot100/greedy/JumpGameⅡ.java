package hot100.greedy;

/**
 * 45. 跳跃游戏 II
 */
public class JumpGameⅡ {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    /**
     * 每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到maxPosition位置的点）作为下次的起跳点
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int n = nums.length;
        int step = 0;
        int end = 0;
        int maxPosition = 0;
        for (int i = 0; i < n - 1; i++){
            maxPosition = Math.max(maxPosition, i + nums[i]);
                if(i == end){
                    end = maxPosition;
                    step++;
                }
        }
        return step;
    }
}
