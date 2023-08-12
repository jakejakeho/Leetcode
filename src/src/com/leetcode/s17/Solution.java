package src.com.leetcode.s17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {

    Map<String, List<String>> map = Map.of(
            "2", List.of("a", "b", "c"),
            "3", List.of("d", "e", "f"),
            "4", List.of("g", "h", "i"),
            "5", List.of("j", "k", "l"),
            "6", List.of("m", "n", "o"),
            "7", List.of("p", "q", "r", "s"),
            "8", List.of("t", "u", "v"),
            "9", List.of("w", "x", "y", "z")
    );

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        String firstDigit = digits.substring(0, 1);
        for (String str : map.get(firstDigit)) {
            if (digits.length() > 1) {
                for (String str2 : letterCombinations(digits.substring(1))) {
                    result.add(str + str2);
                }
            } else {
                result.add(str);
            }
        }
        return result;
    }
}