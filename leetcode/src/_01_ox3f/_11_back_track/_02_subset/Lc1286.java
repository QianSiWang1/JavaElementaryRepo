package _01_ox3f._11_back_track._02_subset;

import java.util.ArrayList;
import java.util.List;

public class Lc1286 {

    List<String> res;
    int len;
    int cur;
    public Lc1286(String characters, int combinationLength) {
        cur = 0;
        char[] chars = characters.toCharArray();
         res = new ArrayList<>();
        len = combinationLength;
        dfs(chars,0,new StringBuilder());

    }

    public static void main(String[] args) {
        new Lc1286("abc",2);
    }

    public void dfs(char[] chars,int index,StringBuilder sb){
        if(sb.length() == len){
            res.add(new String(sb));
            return;
        }
        if(index >= chars.length) return;
        for(int i = index;i<chars.length;i++){
            sb.append(chars[i]);
            dfs(chars,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public String next() {

        return res.get(cur++);
    }

    public boolean hasNext() {
        return cur < len;
    }
}
