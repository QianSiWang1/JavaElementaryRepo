package _01_ox3f._02_two_partition._02_find_min;

/**
 * 875. 爱吃香蕉的珂珂
 */
public class Lc875 {
    public static void main(String[] args) {

    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int x : piles){
            max = Math.max(max,x);
        }
        int min = 1;
        while(min<=max){
            int mid = min + (max - min)/2;
            if(check(mid,piles,h)){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean check(int mid,int[] piles,int h){
        int res = piles.length;
        for(int x : piles){
            res+=(x-1)/mid;
            if(res > h){
                return false;
            }
        }
        return true;
    }
}
