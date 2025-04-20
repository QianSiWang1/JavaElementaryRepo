package ox3f.slidewindowandtwopointer.varslidewindow;

/**
 * 1358. 包含所有三种字符的子字符串数目
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * <p>
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 */
public class Lc1358 {

    public static int numberOfSubstrings(String s){
        int[] target = new int[3];
        char[] chars = s.toCharArray();
        int left = 0;
        int res = 0;
        for(int right = 0;right < chars.length;right++){
            target[chars[right] - 'a'] +=1;
            while(good(target)){
                //res+=(chars.length - right);
                target[chars[left++]-'a']-=1;
            }
            res+=left;
        }
        return res;
    }


    public static boolean good(int[] target) {
        for (int j : target) {
            if (j < 1) {
                return false;
            }
        }
        return true;
    }
}
