package _01_ox3f.datastructure.stack.basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int popIndex = 0;
        Deque<Integer> push = new ArrayDeque<>();
        for(int x : pushed){
            push.push(x);
            while(!push.isEmpty() && push.peek() == popped[popIndex]){
                popIndex++;
                push.pop();
            }
        }
        return popIndex == popped.length;

    }
}
