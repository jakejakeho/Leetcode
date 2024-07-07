package src.com.leetcode.s3213;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private static class TrieNode {
        boolean isWord = false;
        int cost = 0;
        Map<Character, TrieNode> map = new HashMap<>();

        @Override
        public String toString() {
            return "TrieNode{" +
                    "isWord=" + isWord +
                    ", cost=" + cost +
                    ", map=" + map +
                    '}';
        }
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        TrieNode rootNode = new TrieNode();
        for (int w = 0; w < words.length; w++) {
            String word = words[w];
            int cost = costs[w];
            TrieNode pointer = rootNode;
            for (int i = 0; i < word.length(); i++) {
                pointer.map.computeIfAbsent(word.charAt(i), k -> new TrieNode());
                pointer = pointer.map.get(word.charAt(i));
            }
            pointer.isWord = true;
            if (pointer.cost != 0)
                pointer.cost = Math.min(pointer.cost, cost);
            else
                pointer.cost = cost;
        }
        int minCost = recursive(target, rootNode, 0);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    private int recursive(String target, TrieNode rootNode, int index) {
        if (index >= target.length()) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        TrieNode pointer = rootNode;
        while (pointer != null && index < target.length() && pointer.map.containsKey(target.charAt(index))) {
            TrieNode nextPointer = pointer.map.get(target.charAt(index));
            if (nextPointer.isWord) {
                int nextCost = recursive(target, rootNode, index + 1);
                if (nextCost != Integer.MAX_VALUE)
                    minCost = Math.min(minCost, nextPointer.cost + nextCost);
            }
            index++;
            pointer = nextPointer;
        }
        return minCost;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumCost("abcdef", new String[]{"abdef", "abc", "d", "def", "ef"}, new int[]{100, 1, 1, 110, 5}));
        System.out.println(solution.minimumCost("aaaa", new String[]{"z", "zz", "zzz"}, new int[]{1, 10, 100}));
    }
}