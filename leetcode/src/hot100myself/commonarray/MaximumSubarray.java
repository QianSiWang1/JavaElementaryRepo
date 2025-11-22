package hot100myself.commonarray;

public class MaximumSubarray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int pre = Integer.MIN_VALUE;
        int ans = nums[0];
        for(int cur : nums){
            pre = Math.max(cur,pre+cur);
            ans = Math.max(pre,ans);
        }
        return ans;
    }
}
