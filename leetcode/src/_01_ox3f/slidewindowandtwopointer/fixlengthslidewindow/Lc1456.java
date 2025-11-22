package _01_ox3f.slidewindowandtwopointer.fixlengthslidewindow;

import java.util.Set;

public class Lc1456 {
    public static void main(String[] args) {

    }

    public static int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int max = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }
        }
        max = count;
        int right = k;
        while (right < s.length()) {
            if (vowels.contains(s.charAt(right))) {
                count++;
            }
            if (vowels.contains(s.charAt(right - k))) {
                count--;
            }
            max = Math.max(max, count);
            right++;
        }

        return max;

    }
}
