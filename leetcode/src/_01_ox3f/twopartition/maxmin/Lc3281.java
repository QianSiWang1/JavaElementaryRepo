package _01_ox3f.twopartition.maxmin;

import java.util.Arrays;

public class Lc3281 {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n = start.length;
        int left = 0;
        int right = (start[n - 1] + d - start[0]) / (n - 1) + 1;
        while (left  <= right) {
            int mid = (left + right) >>> 1;
            if (check(start, d, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean check(int[] start, int d, int score) {
        long x = Long.MIN_VALUE;
        for (int s : start) {
            x = Math.max(x + score, s); // x 必须 >= 区间左端点 s
            if (x > s + d) {
                return false;
            }
        }
        return true;
    }
}
