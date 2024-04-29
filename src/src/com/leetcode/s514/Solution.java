package src.com.leetcode.s514;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> charMap = new HashMap<>();
        char[] ringArr = ring.toCharArray();
        for (int i = 0; i < ringArr.length; i++) {
            charMap.computeIfAbsent(ringArr[i], (k) -> new ArrayList<>());
            charMap.get(ringArr[i]).add(i);
        }

        char lastChar = key.charAt(key.length() - 1);
        int min = Integer.MAX_VALUE;
        for (int i : charMap.get(lastChar)) {
            min = Math.min(min, dfs(ring, key, charMap, i));
        }

        return 1;
    }

    private int dfs(String ring, String key, Map<Character, List<Integer>> charMap, int i) {
        // clockwise


        // anticlockwise
        return 0;
    }
}