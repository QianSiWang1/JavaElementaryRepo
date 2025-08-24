package ox3f.slidewindowandtwopointer.varslidewindow;

/**
 * 给你两个字符串 word1 和 word2 。
 *
 * 如果一个字符串 x 重新排列后，word2 是重排字符串的 前缀 ，那么我们称字符串 x 是 合法的 。
 *
 * 请你返回 word1 中 合法 子字符串 的数目。
 *
 * 注意 ，这个问题中的内存限制比其他题目要 小 ，所以你 必须 实现一个线性复杂度的解法。
 */
public class Lc3298 {
    public static void main(String[] args) {
        validSubstringCount("bcca","abc");
    }
    public static long validSubstringCount(String word1, String word2) {
        int[] target = new int[26];
        int[] cur = new int[26];
        long res = 0;
        int left = 0;
        char[] targetChar = word2.toCharArray();
        char[] charArray = word1.toCharArray();
        for(char c : targetChar){
            target[c - 'a']++;
        }
        for(int i = 0 ; i < charArray.length;i++){
            cur[charArray[i] - 'a']+=1;
            while(checkValid(cur,target) ){
                cur[charArray[left] - 'a']-=1;
                left++;
            }
            res+=left;

        }
        return res;
    }

    private static boolean checkValid(int[] cur, int[] target) {
        for(int i = 0;i<cur.length;i++){
            if(cur[i] < target[i]){
                return false;
            }
        }
        return true;
    }
}
