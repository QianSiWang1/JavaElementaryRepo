package hot100.twopointer;

/**
 * Num 42. Trapping Rain Water
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int trap = new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }
    public int trap(int[] height) {
        int maxIndex = 0;
        int max = 0;
        for(int i = 0;i<height.length;i++){
            if(height[i]>max){
                max = height[i];
                maxIndex = i;
            }
        }
        int left = 0;
        int left_aera =  0;
        for(int i = 0;i<maxIndex;i++){
            if(height[i]>left){
                left=height[i];
            }else{
                left_aera = left_aera + left-height[i];
            }
        }

        int right = 0;
        int right_aera = 0;
        for(int i = height.length-1;i>maxIndex;i--){
            if(height[i]>right){
                right = height[i];
            }else{
                right_aera = right_aera + right -height[i];
            }
        }
        return left_aera+right_aera;
    }

}
