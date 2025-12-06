package _01_ox3f._01_slide_window_two_pointer._02_var_length;

/**
 * 1234. 替换子串得到平衡字符串
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 *
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 *
 *
 *
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 *
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 *
 * 请返回待替换子串的最小可能长度。
 *
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 */
public class Lc1234 {
    /**
     * 对于本题，设子串的左右端点为 left 和 right，枚举 right，
     * 如果子串外的任意字符的出现次数都不超过 m，
     * 则说明从 left 到 right 的这段子串可以是待替换子串，
     * 用其长度 right−left+1 更新答案的最小值，并向右移动 left，缩小子串长度。
     */
    public int balancedString(String S) {
        char[] s = S.toCharArray();
        int[] cnt = new int['X']; // 也可以用哈希表，不过数组更快一些
        for (char c : s) {
            cnt[c]++;
        }

        int n = s.length;
        int m = n / 4;
        if (cnt['Q'] == m && cnt['W'] == m && cnt['E'] == m && cnt['R'] == m) {
            return 0; // 已经符合要求啦
        }

        int ans = n;
        int left = 0;
        for (int right = 0; right < n; right++) { // 枚举子串右端点
            cnt[s[right]]--;
            while (cnt['Q'] <= m && cnt['W'] <= m && cnt['E'] <= m && cnt['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                cnt[s[left]]++; // 缩小子串
                left++;
            }
        }
        return ans;
    }
}
