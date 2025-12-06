package _01_ox3f._08_data_structure._06_trie.basic;

import java.util.ArrayList;
import java.util.List;

public class Lc3597 {
    class Solution {
        public List<String> partitionString(String s) {
            record Node(Node[] son) {
                Node() {
                    this(new Node[26]);
                }
            }

            List<String> ans = new ArrayList<>();
            Node root = new Node();
            Node cur = root;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (cur.son[c] == null) { // 无路可走？
                    cur.son[c] = new Node(); // 那就造路！
                    ans.add(s.substring(left, i + 1));
                    left = i + 1;
                    cur = root; // 重置
                } else {
                    cur = cur.son[c];
                }
            }
            return ans;
        }
    }
}
