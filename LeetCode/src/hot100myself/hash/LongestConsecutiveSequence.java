package hot100myself.hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        //全部放到set中
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int res = 0;
        for(int n : set){
            if(!set.contains(n-1)){
                int curRes = 1;
                int curNum = n;
                while(set.contains(curNum+1)){
                    curNum++;
                    curRes++;
                }
                res = Math.max(curRes,res);
            }
        }
        return res;
    }
}
