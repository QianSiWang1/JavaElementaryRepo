package _01_ox3f.twopartition.findmin;

public class Lc2187 {
    public long minimumTime(int[] time, int totalTrips) {
        int max = 0;
        for(int x : time){
            max = Math.max(x,max);
        }
        long maxTime = (long) (totalTrips / time.length + 1) * max;
        long minTime = 0;
        while(minTime <= maxTime){
            long midTime = minTime + (maxTime - minTime)/2;
            if(check(time,totalTrips,midTime)){
                maxTime = midTime - 1;
            }else {
                minTime = midTime + 1;
            }
        }

        return minTime;
    }

    public boolean check(int[] time,int target,long midTime){
        long count = 0;
        for(int x : time){
            count += midTime/x;
            if(count>=target){
                return true;
            }
        }
        return false;
    }
}
