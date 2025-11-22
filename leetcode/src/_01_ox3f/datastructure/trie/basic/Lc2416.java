package _01_ox3f.datastructure.trie.basic;

class Node {
    Node[] son = new Node[26];
    int score;
}

class Lc2416 {
    public int[] sumPrefixScores(String[] words) {
        var root = new Node();
        for (var word : words) {
            var cur = root;
            for (var c : word.toCharArray()) {
                c -= 'a';
                if (cur.son[c] == null) cur.son[c] = new Node();
                cur = cur.son[c];
                ++cur.score; // 更新所有前缀的分数
            }
        }

        var n = words.length;
        var ans = new int[n];
        for (var i = 0; i < n; ++i) {
            var cur = root;
            for (var c : words[i].toCharArray()) {
                cur = cur.son[c - 'a'];
                ans[i] += cur.score; // 累加分数，即可得到答案
            }
        }
        return ans;
    }
}


