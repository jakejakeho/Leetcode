package src.com.leetcode.s17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {

    Map<Character, List<String>> map = Map.of('2', List.of("a", "b", "c"), '3', List.of("d", "e", "f"), '4',
        List.of("g", "h", "i"), '5', List.of("j", "k", "l"), '6', List.of("m", "n", "o"), '7',
        List.of("p", "q", "r", "s"), '8', List.of("t", "u", "v"), '9', List.of("w", "x", "y", "z"));

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of("");
        }
        List<String> result = new ArrayList<>();
        char[] charArr = digits.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        recursive(charArr, stringBuilder, 0, result);
        return result;
    }

    private void recursive(char[] charArr, StringBuilder stringBuilder, int index, List<String> result) {
        if (index == charArr.length) {
            result.add(stringBuilder.toString());
            return;
        }

        char c = charArr[index];
        for (String s : map.get(c)) {
            stringBuilder.append(s);
            recursive(charArr, stringBuilder, index + 1, result);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }
}