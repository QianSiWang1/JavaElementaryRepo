package _01_ox3f._01_slide_window_two_pointer._02_var_length;

public class Lc1248 {
    public static void main(String[] args) {

    }

    public int numberOfSubArrays(int[] nums, int k) {
        int left1 = 0;
        int left2 = 0;
        int res = 0;
        int count1 = 0;
        int count2 = 0;
        for(int right = 0;right < nums.length;right++){
            while(count1 >= k){
                count1-=(nums[left1++] & 1);
            }
            while(count2 >=k+1){
                count2-=(nums[left2++] & 1);
            }
            res+=(count1 - count2);
        }
        return res;
    }
}
