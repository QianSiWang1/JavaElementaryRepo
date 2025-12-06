package _01_ox3f._08_data_structure._00_enumeration.right;

public class Lc121 {
    public int maxProfit(int[] prices) {
        int pre  = Integer.MAX_VALUE;
        int res = 0;
        for(int x :prices){
            res = x < pre? Math.max(x-pre,res):res;
            pre = Math.min(pre,x);
        }
        return res;
    }
}
