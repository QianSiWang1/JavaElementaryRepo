package _01_ox3f._08_data_structure._01_presum.hashmap;

public class Lc1524 {
    public static void main(String[] args) {

    }
    public int numOfSubarrays(int[] arr) {
        int odd = 0;
        int even = 1;
        int sum = 0;
        int count = 0;
        for(int x : arr){
            sum+=x;
            if(sum %2 == 0){
                count +=odd;
                even++;
            }else{
                count+=even;
                odd++;
            }
        }
        return count;
    }
}
