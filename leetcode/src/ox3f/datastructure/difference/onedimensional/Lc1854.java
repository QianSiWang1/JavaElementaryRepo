package ox3f.datastructure.difference.onedimensional;

public class Lc1854 {
    public int maximumPopulation(int[][] logs) {
        final int START = 1950;
        int[] arr = new int[102];
        for(int[] temp : logs){
            arr[temp[0] - START]++;
            arr[temp[1] - START]--;
        }
        int max = 0;
        int res = START;
        int sum = 0;
        for(int i = 0;i<102;i++){
            sum+=arr[i];
            if(sum > max){
                max = sum;
                res = START + i;
            }

        }
        return res;
    }
}
