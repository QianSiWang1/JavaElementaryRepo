package hot100.twopointer;

/**
 * Num 11 Container With Most Water
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int i = new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res  = 0;
        while(left < right){
            int area = (right - left) * Math.min(height[left],height[right]);
            res = Math.max(res,area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
