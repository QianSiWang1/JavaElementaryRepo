package ox3f.datastructure.heap.basic;

import java.util.PriorityQueue;

public class Lc3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->{
            if(nums[a] == nums[b]){
                return a-b;
            }else {
                return nums[a]-nums[b];
            }
        });
        for(int i = 0;i<nums.length;i++){
            priorityQueue.add(i);
        }
        while (k-->0){
            Integer poll = priorityQueue.poll();
            nums[poll] = nums[poll] * multiplier;
            priorityQueue.add(poll);
        }
        return nums;
    }

}
