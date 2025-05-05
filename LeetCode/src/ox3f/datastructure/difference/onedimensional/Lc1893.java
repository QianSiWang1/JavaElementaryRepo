package ox3f.datastructure.difference.onedimensional;

public class Lc1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[52];
        for(int[] cur : ranges){
            arr[cur[0]]++;
            arr[cur[1]+1]--;
        }
        int sum = 0;
        for(int i = 0;i<=right;i++){
            sum+=arr[i];
            if(sum<=0 && i>=left){
                return false;
            }
        }
        return true;
    }
}
