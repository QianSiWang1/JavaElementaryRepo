package _01_ox3f._01_slide_window_two_pointer._02_var_length;

public class Lc3258 {
    public static void main(String[] args) {
        System.out.println('1' - '0');
    }


    public int countKConstraintSubstrings(String s, int k) {
        char[] chars = s.toCharArray();
        int[] count = new int[2];
        int left = 0;
        int res = 0;
        for(int right = 0 ; right < chars.length;right++){
            count[chars[right] - '0'] +=1;
            while(count[0] >= k && count[1] >= k){
                count[chars[left++] - '0']-=1;
            }
            res+=right - left + 1;
        }
        return res;
    }
}
