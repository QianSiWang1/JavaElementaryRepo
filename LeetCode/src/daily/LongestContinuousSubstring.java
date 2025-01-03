package daily;

/**
 * 2024年9月19日
 * number 2414
 * An alphabetical continuous string is a string consisting of consecutive letters in the alphabet.
 * In other words, it is any substring of the string "abcdefghijklmnopqrstuvwxyz".
 *
 * For example, "abc" is an alphabetical continuous string, while "acb" and "za" are not.
 * Given a string s consisting of lowercase letters only,
 * return the length of the longest alphabetical continuous substring.
 */
public class LongestContinuousSubstring {

    public int longestContinuousSubstring(String s) {
        int res = 1;
        int cur = 1;
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) - s.charAt(i - 1) == 1){
                cur++;
            }else{
                cur = 1;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
