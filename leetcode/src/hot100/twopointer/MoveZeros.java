package hot100.twopointer;

/**
 * Num 283 MoveZeros
 * Given an integer array nums, move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        for(int i : nums){
            if(i != 0){
                swap(nums,left++,right++);
            }else{
                right++;
            }
        }
    }
    public static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
