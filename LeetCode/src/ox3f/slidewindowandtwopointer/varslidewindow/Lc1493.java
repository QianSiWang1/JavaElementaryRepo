package ox3f.slidewindowandtwopointer.varslidewindow;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 */
public class Lc1493 {
    public int longestSubarray(int[] nums) {
        int left = 0, res = 0;
        int cnt0 = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt0 += 1 - nums[right];
            while (cnt0 > 1) {
                cnt0 -= 1 - nums[left++];
            }
            res = Math.max(res, right - left);
        }
        return res;
    }


}
