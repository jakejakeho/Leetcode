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


    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        for (String str : letterCombinations(digits.substring(1))) {
            result.add(str);
        }
        return result;
    }
}