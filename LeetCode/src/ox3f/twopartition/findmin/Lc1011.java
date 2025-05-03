package ox3f.twopartition.findmin;

import java.util.Arrays;

public class Lc1011 {
    public int shipWithinDays(int[] weights, int days) {
        int max = Arrays.stream(weights).sum();
        int min =  Arrays.stream(weights).max().getAsInt();
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (check(weights, days, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean check(int[] weights, int days, int mid) {
        int need = 1, cur = 0;
        for (int weight : weights) {
            if (cur + weight > mid) {
                ++need;
                cur = 0;
            }
            cur += weight;
        }
        return need <= days;
    }
}
