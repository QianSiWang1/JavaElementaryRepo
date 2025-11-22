package _01_ox3f.twopartition.findmin;

import java.util.Arrays;

public class Lc1870 {
    public static int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length > hour) return -1;
        int left = 0;
        int right = Arrays.stream(dist).max().getAsInt();
        while (left <= right) {
            int mid = left +(right -left)/2;
            if(check(dist,hour,mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static boolean check(int[] dist,double hour,int mid){
        int len = dist.length;
        double res = 0;
        for(int i = 0; i < len;i++){
            if(i != (len - 1)){
                res+=((dist[i]-1)/mid + 1);
            }else{
                res+= ((double) dist[i] / (double) mid);
            }
            if(res > hour){
                return false;
            }
        }
        return true;
    }
}
