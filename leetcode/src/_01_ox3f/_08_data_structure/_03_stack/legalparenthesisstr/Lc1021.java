package _01_ox3f._08_data_structure._03_stack.legalparenthesisstr;

public class Lc1021 {
    public static void main(String[] args) {
        removeOuterParentheses("(()())(())");
    }
    public static String removeOuterParentheses(String s) {
        int level = 0;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                level--;
            }
            if (level > 0) {
                res.append(c);
            }
            if (c == '(') {
                level++;
            }
        }
        return res.toString();
    }
}
