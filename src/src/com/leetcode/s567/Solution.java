package src.com.leetcode.s567;


import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int windowEnd;
        for (windowEnd = 0; windowEnd < s1.length(); windowEnd++) {
            s1Count[s1.charAt(windowEnd) - 'a']++;
            s2Count[s2.charAt(windowEnd) - 'a']++;
        }

        if (Arrays.equals(s1Count, s2Count)) return true;

        int windowStart = 0;
        while (windowEnd < s2.length()) {
            s2Count[s2.charAt(windowStart++) - 'a']--;
            s2Count[s2.charAt(windowEnd++) - 'a']++;
            if (Arrays.equals(s1Count ,s2Count)) return true;
        }
        return false;


    }
}