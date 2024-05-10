package src.com.leetcode.s2306;

import java.util.*;

class Solution {
    public long distinctNames(String[] ideas) {
        Map<String, Set<Character>> map = new HashMap<>();
        for (String idea : ideas) {
            String suffix = idea.substring(1);
            Character prefix = idea.charAt(0);
            map.computeIfAbsent(suffix, (k) -> new HashSet<>());
            map.get(suffix).add(prefix);
        }

        List<Map.Entry<String, Set<Character>>> list = new ArrayList<>(map.size());
        list.addAll(map.entrySet());

        long distinct = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Map.Entry<String, Set<Character>> e1 = list.get(i);
                Map.Entry<String, Set<Character>> e2 = list.get(j);
                Set<Character> s1 = e1.getValue();
                Set<Character> s2 = e2.getValue();
                Set<Character> intersection = new HashSet<>(s1);
                intersection.retainAll(s2);
                distinct += 2 * (s1.size() - intersection.size()) * (s2.size() - intersection.size());
            }
        }
        return distinct;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.distinctNames(new String[]{"coffee", "donuts", "time", "toffee"}));
    }
}