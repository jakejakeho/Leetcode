package src.com.leetcode.s139;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(solution.wordBreak("cars", List.of("car", "ca", "rs")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        List<char[]> wordDictArr = new ArrayList<>();
        for (String dict: wordDict) {
            char[] dictArr = dict.toCharArray();
            wordDictArr.add(dictArr);
        }
        char[] charArr = s.toCharArray();
        Boolean[] hasMatchCache = new Boolean[charArr.length];
        return recursive(0, charArr, wordDictArr, hasMatchCache);
    }

    private boolean recursive(int index, char[] charArr, List<char[]> wordDictArr, Boolean[] hasMatchCache) {
        if (index == charArr.length) {
            return true;
        }
        if (hasMatchCache[index] == null) {
            boolean hasMatch = false;
            for (char[] wordDict : wordDictArr) {
                int pointer = index;
                boolean isMatch = true;
                for (char c : wordDict) {
                    if (pointer >= charArr.length || charArr[pointer++] != c) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    if (recursive(pointer, charArr, wordDictArr, hasMatchCache)) {
                        hasMatch = true;
                    }
                }
            }
            hasMatchCache[index] = hasMatch;
        }
        return hasMatchCache[index];
    }
}