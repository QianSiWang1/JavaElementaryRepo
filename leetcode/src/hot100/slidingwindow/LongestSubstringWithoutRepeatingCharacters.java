package hot100.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Num 3 Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring
 * without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        int i = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba");
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
