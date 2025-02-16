package hot100myself.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsinaString {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] charArray = p.toCharArray();
        int[] target = new int[26];
        for(char c : charArray){
            target[c-'a']++;
        }
        int len = p.length();
        int[] cur = new int[26];
        for(int i =  0;i<len;i++){
            cur[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(target,cur)){
            res.add(0);
        }
        int left = 0;
        int right = len-1;
        while(right<s.length()){
            cur[s.charAt(left)-'a']--;
            cur[s.charAt(right+1)-'a']++;
            left++;
            right++;
            if(Arrays.equals(cur,target)){
                res.add(left+1);
            }
        }
        return res;
    }
}
