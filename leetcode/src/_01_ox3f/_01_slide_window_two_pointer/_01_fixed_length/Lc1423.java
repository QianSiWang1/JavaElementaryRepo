package _01_ox3f._01_slide_window_two_pointer._01_fixed_length;

public class Lc1423 {
    public int maxScore(int[] cardPoints, int k) {
        int[] temp = new int[2 * k];
        for (int i = 0; i < k; i++) {
            temp[k-i] = cardPoints[cardPoints.length - 1 - i];
        }
        for (int i = k; i < 2 * k; i++) {
            temp[i] = cardPoints[i - k];
        }
        int res = 0;
        int sum = 0;
        for (int i = 0; i < 2 * k; i++) {
            sum += temp[i];
            if (i < k - 1) {
                continue;
            }
            res = Math.max(res, sum);
            sum -= temp[i - k + 1];
        }
        return res;
    }
}
