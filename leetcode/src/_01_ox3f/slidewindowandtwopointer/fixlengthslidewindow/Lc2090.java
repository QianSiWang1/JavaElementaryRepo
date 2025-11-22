package _01_ox3f.slidewindowandtwopointer.fixlengthslidewindow;

import java.util.Arrays;

public class Lc2090 {
    public static void main(String[] args) {
        int[] num = {7,4,3,9,1,8,5,2,6};
        System.out.println(Arrays.toString(getAverages(num, 3)));
    }
    public static int[] getAverages(int[] nums, int k){
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        int sum = 0;
        int num = k+k+1;
        for(int i = 0 ;i< nums.length;i++){
            sum+=nums[i];
            if(i< num -1){
                continue;
            }
            res[i-k] = sum/num;
            sum -= nums[i-num+1];
        }
        return res;
    }
}
