package hot100.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * number 128
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        //存在空数组的情况
        int res = 0;
        //从set中取值，已经去重过了
        for(int num : set){
            if(!set.contains(num - 1)){
                int count = 1;
                while(set.contains(num + 1)){
                    num++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
