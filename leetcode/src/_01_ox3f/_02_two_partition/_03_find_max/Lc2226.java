package _01_ox3f._02_two_partition._03_find_max;

import java.util.Arrays;

public class Lc2226 {
    public static void main(String[] args) {
        int[] arr= {5,8,6};
        System.out.println(maximumCandies(arr,3));
    }
    public static int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = Arrays.stream(candies).max().getAsInt();
        while(left <= right){
            int mid = left + (right - left)/2;
            if(check(candies,k,mid)){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static boolean check(int[] candies,long k,int mid){
        int res = 0;
        for(int x : candies){
            while(x >= mid){
                res++;
                x-=mid;
            }
            if(res >= k){
                return true;
            }
        }
        return false;
    }
}
