package hot100.substring;

import java.util.Arrays;

/**
 * 76. Minimum Window Substring
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = new MinimumWindowSubstring().minWindow("abc", "cba");
        System.out.println(s);
    }

    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int[] need = new int[128];
        int[] have = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            if(need[s.charAt(i)] != 0){
                have[s.charAt(i)]++;
            }
        }
        int left = 0,right = t.length() - 1;
        int min = Integer.MAX_VALUE;
        String res = "";
        if(check(need,have)) {
            res = s.substring(left,right+1);
            min = right - left +1;
        }

        while (right < s.length()-1) {
            right++;
            if(need[s.charAt(right)]!=0){
                have[s.charAt(right)]++;
            }
            while (check(need,have)) {
                if(right - left < min) {
                    min = right - left + 1;
                    res = s.substring(left,right+1);
                }
                if(need[s.charAt(left)]!=0){
                    have[s.charAt(left)]--;
                }
                left++;
            }

        }
        return res;
    }

    public boolean check(int[] need,int[] have){
        for (int i = 0; i < need.length; i++) {
            if(need[i] > have[i]){
                return false;
            }
        }
        return true;
    }
}
