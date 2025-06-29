package src.com.leetcode.s3597;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> partitionString(String s) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        Trie pointer = trie;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (pointer.tries[c - 'a'] == null) {
                pointer.tries[c - 'a'] = new Trie();
                result.add(sb.toString());
                sb = new StringBuilder();
                pointer = trie;
            } else {
                pointer = pointer.tries[c - 'a'];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionString("abbccccd"));
        System.out.println(solution.partitionString("aaaa"));
    }

    public class Trie {
        Trie[] tries = new Trie[26];
    }
}