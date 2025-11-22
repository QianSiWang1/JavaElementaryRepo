package _01_ox3f.twopartition.findmin;

import java.util.Arrays;

public class Lc2594 {
    public long repairCars(int[] ranks, int cars) {
        long left = 0;
        long max = Arrays.stream(ranks).max().getAsInt();
        long right = max * cars * cars;
        while(left <=right){
            long mid = left + (right - left)/2;
            if(check(ranks,cars,mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean check(int[] ranks,int cars,long mid){
        int res = 0;
        for(int x : ranks){
            res+= Math.sqrt(mid/x);
            if(res >=cars){
                return true;
            }
        }
        return false;
    }
}
