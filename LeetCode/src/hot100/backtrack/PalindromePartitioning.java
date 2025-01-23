package hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    private static final List<List<String>> ans = new ArrayList<>();
    private static final List<String> path = new ArrayList<>();
    private static String s;

    public static List<List<String>> partition(String str) {
        s = str;
        dfs(0);
        return ans;
    }

    private static void dfs(int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path)); // 复制 path
            return;
        }
        for (int j = i; j < s.length(); j++) { // 枚举子串的结束位置
            if (isPalindrome(i, j)) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1);
                path.remove(path.size() - 1); // 恢复现场
            }
        }
    }

    private static boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
