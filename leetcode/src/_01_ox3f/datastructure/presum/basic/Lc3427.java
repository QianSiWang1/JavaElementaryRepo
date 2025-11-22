package _01_ox3f.datastructure.presum.basic;

public class Lc3427 {
    class Solution {
        public int subarraySum(int[] nums) {
            int n = nums.length;
            int[] s = new int[n + 1];
            for (int i = 0; i < n; i++) {
                s[i + 1] = s[i] + nums[i];
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += s[i + 1] - s[Math.max(i - nums[i], 0)];
            }
            return ans;
        }
    }
}
