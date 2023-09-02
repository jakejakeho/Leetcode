package src.com.leetcode.s2707;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"}));
//        System.out.println(solution.minExtraChar("sayhelloworld", new String[]{"hello", "world"}));
//        System.out.println(solution.minExtraChar("kevlplxozaizdhxoimmraiakbak", new String[]{"yv", "bmab", "hv", "bnsll", "mra", "jjqf", "g", "aiyzi", "ip", "pfctr", "flr", "ybbcl", "biu", "ke", "lpl", "iak", "pirua", "ilhqd", "zdhx", "fux", "xaw", "pdfvt", "xf", "t", "wq", "r", "cgmud", "aokas", "xv", "jf", "cyys", "wcaz", "rvegf", "ysg", "xo", "uwb", "lw", "okgk", "vbmi", "v", "mvo", "fxyx", "ad", "e"}));
    }

    public static class Trie {

        Trie[] trieHashMap;
        boolean isWordEnd;

        public Trie() {
            trieHashMap = new Trie[26];
            isWordEnd = false;
        }

        public void insert(String word) {
            Trie lastTrie = this;
            for (char c : word.toCharArray()) {
                if (lastTrie.trieHashMap[c - 'a'] == null) {
                    lastTrie.trieHashMap[c - 'a'] = new Trie();
                }
                lastTrie = lastTrie.trieHashMap[c - 'a'];
            }
            lastTrie.isWordEnd = true;
        }

        public boolean search(String word, int start, int end) {
            Trie pointer = this;
            if (end >= word.length()) {
                return false;
            }
            for (int i = start; i <= end; i++) {
                char c = word.charAt(i);
                if (pointer.trieHashMap[c - 'a'] == null) {
                    return false;
                } else {
                    pointer = pointer.trieHashMap[c - 'a'];
                }
            }
            return pointer.isWordEnd;
        }

    }


    public int minExtraChar(String s, String[] dictionary) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return dfs(0, s, buildTire(dictionary), cache, maxDictLength(dictionary));
    }

    public Trie buildTire(String[] dictionary) {
        Trie trie = new Trie();
        for (String dict : dictionary) {
            trie.insert(dict);
        }
        return trie;
    }

    public int maxDictLength(String[] dictionary) {
        int max = 0;
        for (String dict : dictionary) {
            max = Math.max(dict.length(), max);
        }
        return max;
    }

    public int dfs(int i, String s, Trie trie, int[] cache, int maxDictLength) {
        if (i >= cache.length) {
            return 0;
        }
        if (cache[i] == -1) {
            // calculate for cache
            int min = 1 + dfs(i + 1, s, trie, cache, maxDictLength);
            for (int j = 1; j <= maxDictLength; j++) {
                int start = i;
                int end = i + j - 1;
                if (trie.search(s, start, end)) {
                    min = Math.min(min, dfs(end + 1, s, trie, cache, maxDictLength));
                }
            }
            cache[i] = min;
        }
        return cache[i];
    }
}