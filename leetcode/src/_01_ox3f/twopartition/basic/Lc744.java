package _01_ox3f.twopartition.basic;

public class Lc744 {
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int left = 0;
            int right = letters.length - 1;
            int res = 0;
            if (letters[letters.length - 1] <= target)
                return letters[0];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (letters[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            return letters[left];
        }
    }
}
