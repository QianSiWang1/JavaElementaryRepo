package _01_ox3f._03_monotonic_stack._01_basic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Lc496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0;i<nums2.length;i++){
            while(!deque.isEmpty() && nums2[i] > deque.peek()){
                map.put(deque.poll(),nums2[i]);
            }
            deque.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for(int j = 0;j<nums1.length;j++){
            res[j] = map.getOrDefault(nums1[j],-1);
        }
        return res;
    }
}
