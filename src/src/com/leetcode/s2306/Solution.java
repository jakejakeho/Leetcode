package src.com.leetcode.s2306;

import java.util.*;

class Solution {
    public long distinctNames(String[] ideas) {
        long distinct = 0;
        Map<Character, Set<String>> map = new HashMap<>();
        for (String idea : ideas) {
            map.computeIfAbsent(idea.charAt(0), (k) -> new HashSet<>());
            map.get(idea.charAt(0)).add(idea.substring(1));
        }

        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                Character k1 = (char) ('a' + i);
                Character k2 = (char) ('a' + j);
                if (i == j || !map.containsKey(k1) || !map.containsKey(k2))
                    continue;
                Set<String> s1 = map.get(k1);
                Set<String> s2 = map.get(k2);
                int s1Count = 0;
                for (String s : s1) {
                    if (!s2.contains(s)) {
                        s1Count++;
                    }
                }

                int s2Count = 0;
                for (String s : s2) {
                    if (!s1.contains(s)) {
                        s2Count++;
                    }
                }
                long com = 2 * ((long) s1Count * s2Count);
                distinct += com;
            }
        }
        return distinct;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.distinctNames(new String[]{"coffee", "donuts", "time", "toffee"}));
    }
}