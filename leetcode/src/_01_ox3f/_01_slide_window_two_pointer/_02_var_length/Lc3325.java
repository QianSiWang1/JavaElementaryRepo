package _01_ox3f._01_slide_window_two_pointer._02_var_length;

import java.util.HashMap;
import java.util.Map;

public class Lc3325 {
    public static void main(String[] args) {
        int i = numberOfSubstrings("abacb", 2);
    }


    public static int numberOfSubstrings(String s, int k) {
        int left = 0;
        int res = 0;
        char[] charArray = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int right = 0;right < charArray.length;right++){
            char temp = charArray[right];
            Integer merge = map.merge(temp, 1, Integer::sum);
            if(merge >=k){
                while(map.get(temp) >=k){
                    map.merge(charArray[left++],-1,Integer::sum);
                }
            }
            res+=left;
        }
        return res;
    }

    public static boolean check(int[] count){
        for(int i : count){
            if(i >=2){
                return true;
            }
        }
        return false;
    }
}
