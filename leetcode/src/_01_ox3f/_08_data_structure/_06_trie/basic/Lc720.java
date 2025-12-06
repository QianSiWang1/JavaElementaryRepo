package _01_ox3f._08_data_structure._06_trie.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Lc720 {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for(String s: words){
            set.add(s);
        }
        Arrays.sort(words,new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 首先按长度降序排列
                if (s1.length() != s2.length()) {
                    return s2.length() - s1.length();
                }
                // 长度相同则按字典序升序排列
                return s1.compareTo(s2);
            }
        });
        for(String temp : words){
            boolean flag =true;
            for(int i = 0 ;i<temp.length();i++){
                if(!set.contains(temp.substring(0,i+1))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return temp;
            }
        }
        return "";
    }
}
