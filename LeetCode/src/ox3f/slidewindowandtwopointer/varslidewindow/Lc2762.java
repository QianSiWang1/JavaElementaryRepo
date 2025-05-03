package ox3f.slidewindowandtwopointer.varslidewindow;

import java.util.PriorityQueue;

/**
 * 2762. 不间断子数组
 */
public class Lc2762 {
    public static void main(String[] args) {

    }
    public long continuousSubarrays(int[] nums) {

        int left = 0;
        int res = 0;
        PriorityQueue<Integer> max = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> min = new PriorityQueue<>(((o1, o2) -> o1 - o2));
        for(int right = 0;right < nums.length;right++){
            max.add(nums[right]);
            min.add(nums[right]);
            while(Math.abs(min.peek() - max.peek()) > 2){
                max.remove(nums[left]);
                min.remove(nums[left]);
                left++;
            }
            res += right - left + 1;
        }
        return res;

    }

}
