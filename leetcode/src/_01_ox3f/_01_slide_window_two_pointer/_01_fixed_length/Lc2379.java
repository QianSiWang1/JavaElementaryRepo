package _01_ox3f._01_slide_window_two_pointer._01_fixed_length;

public class Lc2379 {
    public static void main(String[] args) {
        String blocks = "WBWBBBW";
        System.out.println(minimumRecolors(blocks, 2));
    }
    public static int minimumRecolors(String blocks, int k) {
        int white = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < blocks.length(); i++){
            if(blocks.charAt(i) == 'W'){
                white++;
            }
            if(i < k - 1){
                continue;
            }
            min = Math.min(white,min);
            if(blocks.charAt(i - k + 1) == 'W'){
                white--;
            }
        }
        return min;
    }
}
