package ox3f.slidewindowandtwopointer.varslidewindow;

public class Lc2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        int count_1 = 0;
        int left = 0;
        int len = s.length() + 1;
        String res = "";
        for(int right = 0;right < s.length(); right++){
            if(s.charAt(right) == '1'){
                count_1++;
            }
            while(count_1 == k){
                if(len >= (right - left + 1)){
                    if(len == (right - left + 1)){
                        String temp =  s.substring(left,right+1);
                        res = res.compareTo(temp) < 0?res:temp;
                    }else{
                        res = s.substring(left,right+1);
                        len = right - left + 1;
                    }

                }
                if(s.charAt(left) == '1') count_1--;
                left++;
            }
        }
        return res;
    }
}
