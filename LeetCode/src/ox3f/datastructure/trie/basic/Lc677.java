package ox3f.datastructure.trie.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lc677 {
    Map<String,Integer> map;
    public Lc677() {
        Map<String,Integer> map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int res = 0;
        Set<String> strings = map.keySet();
        for(String s : strings){
            if(s.startsWith(prefix)){
                res+=map.get(s);
            }
        }
        return res;
    }
}
