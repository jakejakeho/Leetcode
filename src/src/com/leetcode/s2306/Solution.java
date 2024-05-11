package src.com.leetcode.s2306;

import java.util.*;

class Solution {
    public long distinctNames(String[] ideas) {
        long distinct = 0;
        HashSet<String>[] map = new HashSet[26];
        for (int i = 0 ;i < 26;i ++) {
            map[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            map[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                if (i == j)
                    continue;
                Set<String> s1 = map[i];
                Set<String> s2 = map[j];
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