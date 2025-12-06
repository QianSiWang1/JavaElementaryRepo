package _01_ox3f._08_data_structure._03_stack.basic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc844 {
    public static void main(String[] args) {
        backspaceCompare("ab##", "ad##");
    }

    public static boolean backspaceCompare(String s, String t) {
        Deque<Character> dequeS = new ArrayDeque<>();
        Deque<Character> dequeT = new ArrayDeque<>();
        char[] charS = s.toCharArray();
        for (char temp : charS) {
            if (temp == '#') {
                if (dequeS.isEmpty()) continue;
                dequeS.pop();
            } else {
                dequeS.push(temp);
            }
        }
        char[] charT = t.toCharArray();
        for (char temp : charT) {
            if (temp == '#') {
                if (dequeT.isEmpty()) continue;
                dequeT.pop();
            } else {
                dequeT.push(temp);
            }
        }
        if (dequeT.size() != dequeS.size()) return false;
        while (!dequeS.isEmpty()) {
            if (dequeT.pop() != dequeS.pop()) return false;
        }
        return true;
    }
}
