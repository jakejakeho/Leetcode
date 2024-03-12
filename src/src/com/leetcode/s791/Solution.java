package src.com.leetcode.s791;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (Character c : order.toCharArray()) {
            countMap.put(c, 0);
        }

        for (Character c : s.toCharArray()) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : order.toCharArray()) {
            if (countMap.get(c) > 0) {
                sb.append(String.valueOf(c).repeat(Math.max(0, countMap.get(c))));
            }
        }

        for (Character c : s.toCharArray()) {
            if (!countMap.containsKey(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.customSortString("cba", "abcd"));
    }
}