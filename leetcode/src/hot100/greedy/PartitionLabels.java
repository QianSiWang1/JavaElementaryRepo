package hot100.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 */
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

   public static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        List<Integer> partition = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int lastIndex = last[s.charAt(i) - 'a'];
            // end每次遇到新的字符的时候，需要更新一个区间最后位置
            end = Math.max(end, lastIndex);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
   }
}
