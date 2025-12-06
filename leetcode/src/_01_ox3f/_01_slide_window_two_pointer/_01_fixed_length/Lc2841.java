package _01_ox3f._01_slide_window_two_pointer._01_fixed_length;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc2841 {
    public static void main(String[] args) {

    }

    public static long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long res = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i < k - 1) {
                map.merge(nums.get(i), 1, Integer::sum);
                sum += nums.get(i);
                continue;
            }
            map.merge(nums.get(i), 1, Integer::sum);
            sum += nums.get(i);
            if (map.size() >= m) {
                res = Math.max(res, sum);
            }
            map.merge(nums.get(i - k + 1), -1, Integer::sum);
            if (map.get(nums.get(i - k + 1)) == 0) {
                map.remove(nums.get(i - k + 1));
            }
            sum -= nums.get(i - k + 1);
        }
        return res;
    }
}
