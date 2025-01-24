package hot100.dynamicprogramm;

 import java.util.HashSet;
 import java.util.List;
 import java.util.Set;

/**
 * 139. 单词拆分
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict =        List.of("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
