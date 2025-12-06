package _01_ox3f._08_data_structure._00_enumeration.right;

import java.util.HashMap;
import java.util.Map;

public class Lc2364 {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long ans = (long) n * (n - 1) / 2;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i] - i;
            int c = cnt.getOrDefault(x, 0);
            ans -= c;
            cnt.put(x, c + 1);
        }
        return ans;
    }
}
