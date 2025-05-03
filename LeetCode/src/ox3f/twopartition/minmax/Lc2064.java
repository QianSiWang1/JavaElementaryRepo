package ox3f.twopartition.minmax;

import java.util.Arrays;

public class Lc2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = Arrays.stream(quantities).max().getAsInt();
        while(left <= right){
            int mid = left + (right - left)/2;
            if(check(n,quantities,mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean check(int n,int[] quantities,int mid){
        int res = 0;
        for(int x : quantities){
            res+=(x-1)/mid + 1;
            if(res > n) return false;
        }
        return true;
    }
}
