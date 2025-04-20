package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc368 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Lc368().largestDivisibleSubset(nums));
    }
    List<Integer> temp = new ArrayList<>();
    int max = 0;
    List<Integer> res = new ArrayList<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        dfs(0,nums);
        return res;
    }

    public void dfs(int i,int[] nums){
        if(i ==  nums.length){
            if(temp.size()> max){
                res = new ArrayList<>(temp);
                max = temp.size();
            }
            return;
        }
        dfs(i+1,nums);
        if(temp.size() == 0 ||  nums[i]% (temp.get(temp.size()-1)) == 0){
            temp.add(nums[i]);
            dfs(i+1,nums);
            temp.remove(temp.size()-1);
        }
    }
}
