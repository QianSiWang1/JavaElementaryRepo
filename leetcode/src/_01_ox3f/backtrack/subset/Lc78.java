package _01_ox3f.backtrack.subset;

import java.util.ArrayList;
import java.util.List;

public class Lc78 {
}

class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(0,nums,track,res);
        return res;
    }

    public void dfs(int start,int[] nums,List<Integer> track,List<List<Integer>> res){
        for(int i = start;i<nums.length;i++){
            track.add(nums[i]);
            res.add(new ArrayList<>(track));
            dfs(i+1,nums,track,res);
            track.remove(track.size()-1);
        }
    }
}

class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == nums.length) { // 子集构造完毕
            ans.add(new ArrayList<>(path)); // 复制 path
            return;
        }

        // 不选 nums[i]
        dfs(i + 1);

        // 选 nums[i]
        path.add(nums[i]);
        dfs(i + 1);
        path.remove(path.size() - 1); // 恢复现场
    }
}

class Solution3 {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        ans.add(new ArrayList<>(path)); // 复制 path
        for (int j = i; j < nums.length; j++) { // 枚举选择的数字
            path.add(nums[j]);
            dfs(j + 1);
            path.remove(path.size() - 1); // 恢复现场
        }
    }
}