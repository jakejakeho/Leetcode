package src.com.leetcode.s1461;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int combinations = 1 << k;
        int possibility = s.length() - k + 1;
        if (combinations > possibility) {
            return false;
        }
        Set<String> set = new HashSet<>();

        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder1.append(s.charAt(i));
        }
        for (int i = 0; i <= s.length() - k; i++) {
            String test = stringBuilder1.toString();
            if (set.add(test)) {
                combinations--;
            }
            if (combinations == 0) {
                return true;
            }
            stringBuilder1.deleteCharAt(0);
            if (i + k < s.length())
                stringBuilder1.append(s.charAt(i + k));
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAllCodes("00110110", 2));
    }
}