package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 */
public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res,nums,temp,visited);
        return res;
    }

    public static void dfs(List<List<Integer>> res,int[] nums,List<Integer> temp,int[] visited){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i < nums.length;++i){
            if(visited[i] == 1 || (i > 0 && nums[i] == nums[i-1] && visited[i-1] != 1)){
                continue;
            }
            visited[i] = 1;
            temp.add(nums[i]);
            dfs(res,nums,temp,visited);
            temp.remove(temp.size()-1);
            visited[i]=0;
        }
    }
}
