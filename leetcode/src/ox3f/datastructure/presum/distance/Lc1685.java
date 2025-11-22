package ox3f.datastructure.presum.distance;

public class Lc1685 {
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        getSumAbsoluteDifferences(arr);
    }
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        int[] pre = new int[nums.length];
        pre[0] = 0;
        for(int i = 1;i<nums.length;i++){
            pre[i] = pre[i-1]+nums[i-1];
        }
        int[] suf =  new int[nums.length];
        suf[nums.length - 1] = 0;
        for(int i = nums.length - 2;i >=0;i--){
            suf[i] = suf[i+1] + nums[i+1];
        }
        int count = nums.length - 1;
        for(int i = 0 ;i< nums.length;i++){
            if(i == 0){
                res[i] = suf[i] - count*nums[i];
                continue;
            }
            if(i == nums.length -1 ){
                res[i] = count*nums[i] - pre[i];
                continue;
            }
            res[i] = i*nums[i] - pre[i] + suf[i] - (count-i) * nums[i];
        }
        return res;
    }
}
