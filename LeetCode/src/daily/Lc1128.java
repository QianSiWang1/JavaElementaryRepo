package daily;

public class Lc1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[][] cnt = new int[10][10];
        for (int[] d : dominoes) {
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]); // 保证 a <= b
            ans += cnt[a][b]++;
        }
        return ans;
    }
}
