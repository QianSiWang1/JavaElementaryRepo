package ox3f.datastructure.stack.legalparenthesisstr;

public class Lc1614 {
    public int maxDepth(String s) {
        char[] charArray = s.toCharArray();
        int level = 0;
        int res = 0;
        int left = 0;
        for(char c : charArray){
            if(c == '('){
                left++;
                res = Math.max(res,left);
            }
            if(c == ')'){
                left--;
            }
        }
        return res;
    }
}
