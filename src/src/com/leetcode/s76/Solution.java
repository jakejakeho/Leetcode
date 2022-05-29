package src.com.leetcode.s76;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int matched = 0;
        int windowStart = 0;
        int minLen = s.length() + 1;
        int minStrStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char right = s.charAt(windowEnd);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if ((windowEnd - windowStart + 1) < minLen) {
                    minLen = windowEnd - windowStart + 1;
                    minStrStart = windowStart;
                }
                char deleted = s.charAt(windowStart++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(minStrStart, minStrStart + minLen);
    }
/*    public String minWindow(String s, String t) {
//        if (s.length() < t.length()) return "";
//
//
//        int[] tCount = new int[128];
//
//        // get t count
//        for (int i = 0; i < t.length(); i++) {
//            tCount[t.charAt(i)]++;
//        }
//
//        // sliding window
//        for (int i = t.length() - 1; i <= s.length() - 1; i++) {
//            int[] sCount = new int[128];
//            int windowStart = 0;
//            int windowEnd = i;
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int j = windowStart; j <= windowEnd; j++) {
//                stringBuilder.append(s.charAt(j));
//                sCount[s.charAt(j)]++;
//            }
//
//            if (validSubStr(sCount, tCount)) {
//                return stringBuilder.toString();
//            }
//
//            while (windowEnd + 1 < s.length()) {
//                stringBuilder.deleteCharAt(0);
//                sCount[s.charAt(windowStart)]--;
//                windowStart++;
//                windowEnd++;
//                stringBuilder.append(s.charAt(windowEnd));
//                sCount[s.charAt(windowEnd)]++;
//                if (validSubStr(sCount, tCount)) {
//                    return stringBuilder.toString();
//                }
//            }
//        }
//        return "";
//    }
 */

    private boolean validSubStr(int[] sCount, int[] tCount) {
        for (int i = 0; i < tCount.length; i++) {
            if (tCount[i] > 0 && tCount[i] > sCount[i]) {
                return false;
            }
        }
        return true;
    }
}