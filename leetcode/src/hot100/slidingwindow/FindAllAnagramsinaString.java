package hot100.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Num 438 Find All Anagrams in a String
 *Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 */
public class FindAllAnagramsinaString {
    public static void main(String[] args) {

    }
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for(int i = 0;i < p.length();i++){
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sArr,pArr)){
            res.add(0);
        }
        for(int i = 0;i < s.length() - p.length();i++){
            sArr[s.charAt(i) - 'a']--;
            sArr[s.charAt(i + p.length()) - 'a']++;
            if(Arrays.equals(sArr,pArr)){
                res.add(i+1);
            }
        }
        return res;
    }
}
