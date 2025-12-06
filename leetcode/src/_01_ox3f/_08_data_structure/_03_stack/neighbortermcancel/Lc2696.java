package _01_ox3f._08_data_structure._03_stack.neighbortermcancel;

public class Lc2696 {
    public int minLength(String s) {
        while(s.contains("AB") || s.contains("CD")){
            s = s.replaceAll("AB","");
            s = s.replaceAll("CD","");
        }
        return s.length();
    }
}
