package _01_ox3f._08_data_structure._02_difference.onedimensional;

public class Lc1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] d = new int[1001];
        for (int[] t : trips) {
            int num = t[0], from = t[1], to = t[2];
            d[from] += num;
            d[to] -= num;
        }
        int s = 0;
        for (int v : d) {
            s += v;
            if (s > capacity) {
                return false;
            }
        }
        return true;
    }
}
