package ox3f.datastructure.stack.legalparenthesisstr;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc921 {
    public int minAddToMakeValid(String s) {
        char[] charArray = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for(char c : charArray){
            if(c == '('){
                deque.push(c);
            }
            if (c == ')') {
                if (!deque.isEmpty() && deque.peek() == '(') {
                    deque.pop();
                }else{
                    deque.push(c);
                }

            }
        }
        return deque.size();
    }
}
