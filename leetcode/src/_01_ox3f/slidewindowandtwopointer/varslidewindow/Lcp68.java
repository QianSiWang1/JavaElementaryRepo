package _01_ox3f.slidewindowandtwopointer.varslidewindow;

import java.util.HashMap;
import java.util.Map;

public class Lcp68 {
    public static void main(String[] args) {

    }
    public int beautifulBouquet(int[] flowers, int cnt) {
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0;
        int res = 0;
        for(int right = 0;right < flowers.length; right++){
            Integer merge = map.merge(flowers[right], 1, Integer::sum);
            while(map.get(flowers[right]) > cnt){
                map.merge(flowers[left++],-1,Integer::sum);
            }
            res+=right-left+1;
        }
        return res;
    }
}
