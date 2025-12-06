package _01_ox3f._01_slide_window_two_pointer._01_fixed_length;

public class Lc1343 {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,5,5,5,8};
        System.out.println(numberOfSubarrays(arr, 3, 4));
    }
    public static int numberOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        double sum = 0;
        double  max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];//入
            if (i < k-1){
                continue;
            }

            max = Math.max(max,sum);//更新
            if(sum/k >= threshold) res++;
            sum -= arr[i - k+1];//出

        }
        return res;
    }
}
