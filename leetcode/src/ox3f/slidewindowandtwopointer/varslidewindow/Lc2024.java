package ox3f.slidewindowandtwopointer.varslidewindow;

/**
 *
 */
public class Lc2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        //0 true 1 false
        int[] tf = new int[2];
        char[] charArray = answerKey.toCharArray();
        int left = 0;
        int res = 0;
        for(int right = 0;right < charArray.length;right++){
            if('T' == charArray[right]){
                tf[0]++;
            }else{
                tf[1]++;
            }
            while(true){
                int temp = Math.min(tf[0],tf[1]);
                if(temp > k){
                    char leftChar = charArray[left];
                    if('T' == leftChar){
                        tf[0]--;
                    }else{
                        tf[1]--;
                    }
                    left++;
                }else{
                    break;
                }
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }

}
