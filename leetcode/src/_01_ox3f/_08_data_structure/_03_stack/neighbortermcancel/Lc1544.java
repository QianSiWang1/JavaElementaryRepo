package _01_ox3f._08_data_structure._03_stack.neighbortermcancel;

public class Lc1544 {
    class Solution {
        public String makeGood(String s) {
            StringBuffer stack = new StringBuffer();
            int top = -1;
            for (int i = 0; i < s.length(); ++i) {
                char ch = s.charAt(i);
                if (top >= 0 && Character.toLowerCase(stack.charAt(top)) == Character.toLowerCase(ch) && stack.charAt(top) != ch) {
                    stack.deleteCharAt(top);
                    --top;
                } else {
                    stack.append(ch);
                    ++top;
                }
            }
            return stack.toString();
        }
    }
}
