package src.com.leetcode.s752;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadEndSet = new HashSet<>(Arrays.asList(deadends));

        StringBuilder stringBuilder = new StringBuilder(target);
        int match = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            stringBuilder.setCharAt(i, (char)(stringBuilder.charAt(i) + 1));
            if (deadEndSet.contains(stringBuilder.toString())) {
                match++;
            }
            stringBuilder.setCharAt(i, (char)(stringBuilder.charAt(i) - 2));
            if (deadEndSet.contains(stringBuilder.toString())) {
                match++;
            }
            stringBuilder.setCharAt(i, (char)(stringBuilder.charAt(i) + 1));
        }

        if (match == 8) {
            return -1;
        }

        StringBuilder pickLock = new StringBuilder("0000");
        int turn = 0;
        while (!pickLock.equals(target)) {

        }
    }
}