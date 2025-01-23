package hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * num 78 子集
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            list.add(track);
            return list;
        }
        list.add(new ArrayList<>());
        dfs(0, nums, track, list);
        return list;
    }
    public static void dfs(int curr, int[] nums, List<Integer> track, List<List<Integer>> list) {
        for(int i = curr; i < nums.length; i++) {
            track.add(nums[i]);
            list.add(new ArrayList<>(track));
            dfs(i+1, nums, track, list);
            track.remove(track.size()-1);
        }
    }
}
