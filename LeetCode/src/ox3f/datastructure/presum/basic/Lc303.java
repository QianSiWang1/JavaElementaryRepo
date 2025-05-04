package ox3f.datastructure.presum.basic;

public class Lc303 {
    int[] preSum;

    public Lc303(int[] nums) {
        preSum = new int[nums.length];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            preSum[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        if(left == 0) return preSum[right];
        return preSum[right] - preSum[left-1];
    }
}
