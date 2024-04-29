package src.com.leetcode.s514;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> charMap = new HashMap<>();
        char[] ringArr = ring.toCharArray();
        for (int i = 0; i < ringArr.length; i++) {
            charMap.computeIfAbsent(ringArr[i], (k) -> new ArrayList<>());
            charMap.get(ringArr[i])
                   .add(i);
        }

        int keyIndex = key.length() - 1;
        char lastChar = key.charAt(keyIndex);
        int min = Integer.MAX_VALUE;
        for (int i : charMap.get(lastChar)) {
            min = Math.min(min, dfs(ring, key, charMap, i, keyIndex));
        }
        return min;
    }

    private int dfs(String ring, String key, Map<Character, List<Integer>> charMap, int i, int keyIndex) {
        if (keyIndex <= 0) {
            return 1;
        }

        int nextKeyIndex = keyIndex - 1;
        char nextKey = key.charAt(nextKeyIndex);

        List<Integer> nextIndices = charMap.getOrDefault(nextKey, Collections.emptyList());

        int minDistance = Integer.MAX_VALUE;
        int nextI = -1;

        for (int nextRingIndex : nextIndices) {
            int clockwiseDistance = (i + ring.length() - nextRingIndex) % ring.length();
            int antiClockwiseDistance = (nextRingIndex + ring.length() - i) % ring.length();
            if (clockwiseDistance < minDistance) {
                minDistance = clockwiseDistance;
                nextI = nextRingIndex;
            }

            if (antiClockwiseDistance < minDistance) {
                minDistance = antiClockwiseDistance;
                nextI = nextRingIndex;
            }
        }

        return 1 + minDistance + dfs(ring, key, charMap, nextI, nextKeyIndex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a1 = solution.findRotateSteps("godding", "gd");
        int answer = a1;
        int expected = 4;
        System.out.printf("%d %d==%d %b%n\n", answer, answer, expected, answer == expected);
        int a2 = solution.findRotateSteps("godding", "godding");
        answer = a2;
        expected = 13;
        System.out.printf("%d %d==%d %b%n\n", answer, answer, expected, answer == expected);
        int a3 = solution.findRotateSteps("edcba", "abcde");
        answer = a3;
        expected = 10;
        System.out.printf("%d %d==%d %b%n\n", answer, answer, expected, answer == expected);
    }
}