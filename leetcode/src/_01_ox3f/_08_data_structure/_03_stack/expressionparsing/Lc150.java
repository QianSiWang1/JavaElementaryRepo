package _01_ox3f._08_data_structure._03_stack.expressionparsing;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        int num1;
        int num2;
        for(String s : tokens){
            if("+".equals(s)){
                num1 = deque.pop();
                num2 = deque.pop();
                deque.push(num1 +num2 );
            }else if("-".equals(s)){
                num1 = deque.pop();
                num2 = deque.pop();
                deque.push(num2 - num1);
            }else if("*".equals(s)){
                num1 = deque.pop();
                num2 = deque.pop();
                deque.push(num2 * num1);
            }else if("/".equals(s)){
                num1 = deque.pop();
                num2 = deque.pop();
                deque.push(num2 / num1);
            }else {
                deque.push(Integer.parseInt(s));
            }
        }
        return deque.pop();
    }
}
