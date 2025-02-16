package hot100myself.twopointer;

public class MoveZeroes {

    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {
        int p0 = 0,p1=0;
        while(p1 < nums.length){
            if(nums[p1] != 0){
                swap(nums,p0,p1);
                p0++;
                p1++;
            }else {
                p1++;
            }
        }
    }

    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
