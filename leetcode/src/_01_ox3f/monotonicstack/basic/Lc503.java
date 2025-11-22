package _01_ox3f.monotonicstack.basic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Lc503 {
    public static void main(String[] args) {
        int[] arr= {1,2,1};
        System.out.println(nextGreaterElements(arr));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0;i<nums.length;i++){
            while(!deque.isEmpty() && nums[i] > nums[deque.peek()]){
                Integer poll = deque.poll();
                res[poll] = nums[i];
            }
            deque.push(nums[i]);
        }
        return res;
    }
}
