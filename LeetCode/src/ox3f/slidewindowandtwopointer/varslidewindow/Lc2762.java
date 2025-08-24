package ox3f.slidewindowandtwopointer.varslidewindow;

import java.util.PriorityQueue;
import java.util.TreeMap;

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
    class Solution {
        public long continuousSubarrays(int[] nums) {
            long ans = 0;
            TreeMap<Integer, Integer> t = new TreeMap<>();
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                t.merge(nums[right], 1, Integer::sum); // t[nums[right]]++
                while (t.lastKey() - t.firstKey() > 2) {
                    int out = nums[left];
                    int c = t.get(out);
                    if (c == 1) {
                        t.remove(out);
                    } else {
                        t.put(out, c - 1);
                    }
                    left++;
                }
                ans += right - left + 1;
            }
            return ans;
        }
    }

}
