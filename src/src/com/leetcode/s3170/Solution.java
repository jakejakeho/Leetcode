package src.com.leetcode.s3170;

import java.util.*;

class Solution {

    private class Data {
        char charToDelete;
        int index;
    }

    public String clearStars(String s) {
        List<Stack<Integer>> countMap = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            countMap.add(new Stack<>());
        }
        Set<Integer> indicesToDelete = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                for (int j = 0; j < 26; j++) {
                    if (!countMap.get(j).isEmpty()) {
                        indicesToDelete.add(countMap.get(j).pop());
                        break;
                    }
                }
            } else {
                countMap.get(s.charAt(i) - 'a').push(i);
            }
        }
        if (indicesToDelete.isEmpty()) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int deleteIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                if (deleteIndex < indicesToDelete.size() && indicesToDelete.contains(i)) {
                    deleteIndex++;
                } else {
                    stringBuilder.append(s.charAt(i));
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.clearStars("ee**"));
    }
}