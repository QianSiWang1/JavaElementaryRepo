package ox3f.datastructure.enumeration.right;

import java.util.HashSet;

public class Lc2441 {
    class Solution {
        public int findMaxK(int[] nums) {
            int ans = -1;
            var s = new HashSet<Integer>();
            for (int x : nums) {
                if (s.contains(-x))
                    ans = Math.max(ans, Math.abs(x));
                s.add(x);
            }
            return ans;
        }
    }
}

