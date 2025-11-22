package ox3f.datastructure.heap.basic;

import java.util.PriorityQueue;

public class Lc1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for(int x: stones){
            integers.add(x);
        }
        while(integers.size() >= 2){
            int num1 = integers.poll();
            int num2 = integers.poll();
            if((num1 - num2) == 0){
                continue;
            }else {
                integers.add(num1 - num2);
            }
        }
        return integers.isEmpty() ? 0 : integers.poll();
    }
}
