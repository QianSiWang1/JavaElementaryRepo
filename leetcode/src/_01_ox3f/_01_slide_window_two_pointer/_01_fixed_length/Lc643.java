package _01_ox3f._01_slide_window_two_pointer._01_fixed_length;

public class Lc643 {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double  max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];//入
            if (i < k-1){
                continue;
            }

            max = Math.max(max,sum);//更新
            sum -= nums[i - k+1];//出

        }
        return max/k;
    }
}
