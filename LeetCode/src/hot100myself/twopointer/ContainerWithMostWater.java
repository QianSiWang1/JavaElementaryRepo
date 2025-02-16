package hot100myself.twopointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {

    }
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            int high = Math.min(height[left],height[right]);
            res = Math.max(res,high*(right-left));
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}
