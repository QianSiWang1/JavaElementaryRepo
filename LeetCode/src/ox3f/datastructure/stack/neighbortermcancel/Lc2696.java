package ox3f.datastructure.stack.neighbortermcancel;

public class Lc2696 {
    public int minLength(String s) {
        while(s.contains("AB") || s.contains("CD")){
            s = s.replaceAll("AB","");
            s = s.replaceAll("CD","");
        }
        return s.length();
    }
}
