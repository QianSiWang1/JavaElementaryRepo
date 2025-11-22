package hot100myself.hash;

import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String string = new String(charArray);
            if(map.containsKey(string)){
                List<String> strings = map.get(string);
                strings.add(str);
            }else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(string,temp);
            }
        }
        return new ArrayList<>(map.values());

    }
}
