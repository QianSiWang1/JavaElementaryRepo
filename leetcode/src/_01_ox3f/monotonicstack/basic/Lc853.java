package _01_ox3f.monotonicstack.basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc853 {
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            double[] time = new double[target]; // 代表第i个位置出发的车到达终点所需的时间
            for (int i = 0; i < position.length; i++) {
                time[position[i]] = (target - position[i]) / (double) speed[i]; // 记录每个位置到达终点所需的时间
            }
            Deque<Double> stack = new ArrayDeque<>(); // 记录到每个车队上最慢到达终点的所需时间是多少？
            for (int i = 0; i < target; i++) {
                if (time[i] > 0) {
                    while (!stack.isEmpty() && time[i] >= stack.peek()) {
                        stack.pop();
                    }
                    stack.push(time[i]);
                }
            }
            return stack.size();
        }
    }
}
