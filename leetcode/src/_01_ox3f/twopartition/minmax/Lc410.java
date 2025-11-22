package _01_ox3f.twopartition.minmax;

import java.util.Arrays;

public class Lc410 {
    public static void main(String[] args) {
        int[] arr= {1,4,4};
        System.out.println(splitArray(arr,3));
    }
    public static int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        while(left <=right){
            int mid = left+ (right-left)/2;
            if(check(nums,k,mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean check(int[] nums,int k,int mid){
        int cnt = 1;
        int s = 0;
        for (int x : nums) {
            if (s + x <= mid) {
                s += x;
                continue;
            }
            if (cnt == k) { // 不能继续划分
                return false;
            }
            cnt++; // 新划分一段
            s = x;
        }
        return true;
    }
}
