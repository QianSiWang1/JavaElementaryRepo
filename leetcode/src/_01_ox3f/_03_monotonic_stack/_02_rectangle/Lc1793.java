package _01_ox3f._03_monotonic_stack._02_rectangle;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc1793 {
    public static void main(String[] args) {
        int[] arr = {1,4,3,7,4,5};
        System.out.println(maximumScore(arr,3));

    }
    public static int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (!st.isEmpty() && x <= nums[st.peek()]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int[] right = new int[n];
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            while (!st.isEmpty() && x <= nums[st.peek()]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] + 1 <= k && right[i] - 1 >= k) {
                ans = Math.max(ans, nums[i] * (right[i] - 1 - (left[i] + 1) + 1));
            }
        }
        return ans;
    }
}
