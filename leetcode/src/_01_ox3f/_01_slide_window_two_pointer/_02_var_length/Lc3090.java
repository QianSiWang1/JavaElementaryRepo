package _01_ox3f._01_slide_window_two_pointer._02_var_length;

import java.util.HashMap;
import java.util.Map;

/**
 * 3090. 每个字符最多出现两次的最长子字符串
 * 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。
 */
public class Lc3090 {

    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for(int right = 0; right < s.length(); right++){
            Character c = s.charAt(right);
            map.merge(c, 1, Integer::sum);
            while(map.get(c).intValue() > 2){
                map.merge(s.charAt(left), -1, Integer::sum);
            }
            left++;
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
