package _01_ox3f._02_two_partition._02_find_min;

import java.util.Arrays;

public class Lc1482 {
    public static void main(String[] args) {
        int[] bloomDay = {5,37,55,92,22,52,31,62,99,64,92,53,34,84,93,50,28};
        System.out.println(minDays(bloomDay,8,2));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k) return -1;
        int left = 1;
        int right = Arrays.stream(bloomDay).max().getAsInt();
        while(left <= right){
            int mid = left  + (right - left)/2;
            if(check(bloomDay,m,k,mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean check(int[] bloomDay,int m,int k,int mid){
        int res = 0;
        int temp = 0;
        for(int x : bloomDay){
            if(x <=mid){
                temp++;
            }else {
                temp = 0;
            }
            if(temp == k){
                res++;
                temp=0;
            }
            if(res >= m){
                return true;
            }
        }
        return false;
    }
}
