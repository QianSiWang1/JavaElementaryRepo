package ox3f.twopartition.findmin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lc475 {
    public static void main(String[] args) {
        int[] house = {1, 5};
        int[] heaters = {10};
        System.out.println(findRadius(house, heaters));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int left = 0;
        int right = Math.max(Arrays.stream(houses).max().getAsInt(), Arrays.stream(heaters).max().getAsInt());

        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(houses, heaters, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean check(int[] houses, int[] heaters, int mid) {


        int i = 0, j = 0;
        while (i < houses.length && j < heaters.length) {
            // 计算当前加热器能覆盖的范围 [left, right]
            int left = heaters[j] - mid;
            int right = heaters[j] + mid;

            // 如果房屋在当前加热器覆盖范围内
            if (houses[i] >= left && houses[i] <= right) {
                i++;  // 检查下一个房屋
            } else if (houses[i] < left) {
                return false;  // 房屋无法被任何加热器覆盖
            } else {
                j++;  // 尝试下一个加热器
            }
        }

        return i == houses.length;  // 是否所有房屋都被覆盖
    }
}
