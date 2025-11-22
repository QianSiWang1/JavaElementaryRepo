package _01_ox3f.monotonicstack.basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>(); // todolist
        for (int i = 0; i < n; i++) {
            int t = temperatures[i];
            while (!st.isEmpty() && t > temperatures[st.peek()]) {
                int j = st.pop();
                ans[j] = i - j;
            }
            st.push(i);
        }
        return ans;
    }

}
