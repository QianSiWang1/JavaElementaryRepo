package _01_ox3f._03_monotonic_stack._01_basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc1475 {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = prices;
        for(int i = 0;i < prices.length;i++){
            while(!deque.isEmpty() &&  prices[i] <= prices[deque.peek()]){
                Integer poll = deque.poll();
                res[poll] -=prices[i];
            }
            deque.push(i);
        }
        return res;
    }
}
