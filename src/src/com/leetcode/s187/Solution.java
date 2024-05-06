package src.com.leetcode.s187;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return Collections.emptyList();
        }
        Map<String, Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder(s.substring(0, 10));
        int i = 0;
        do {
            String current = stringBuilder.toString();
            map.put(current, map.getOrDefault(current, 0) + 1);
            stringBuilder.deleteCharAt(0);
            if (i + 10 < s.length()) {stringBuilder.append(s.charAt(i + 10));}
            i++;
        } while (i <= s.length() - 10);

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}