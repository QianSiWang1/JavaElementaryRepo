package ox3f.datastructure.enumeration.right;

import java.util.HashMap;
import java.util.Map;

public class Lc2342 {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int x : nums) {
            int sum = getSum(x);
            if (map.containsKey(sum)) {
                Integer i = map.get(sum);
                res = Math.max(res, x + i);
                map.put(sum, Math.max(i, x));
            } else {
                map.put(sum, x);
            }

        }
        return res==0 ? -1:res;
    }

    public int getSum(int x) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
