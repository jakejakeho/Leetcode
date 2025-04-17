package src.com.leetcode.s2490;
import java.util.ArrayList;
import java.util.List;

class Solution {

    record Word(char firstChar, char lastChar) {}

    public boolean isCircularSentence(String sentence) {
        List<Word> words = new ArrayList<>();
        char firstChar = 'a';
        char lastChar = 'a';
        boolean lastIsSpace = true;
        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);
            if (lastIsSpace) {
                firstChar = currentChar;
            }
            if (currentChar == ' ' || i == (sentence.length() - 1)) {
                if (i == (sentence.length() - 1)) {
                    lastChar = currentChar;
                }
                words.add(new Word(firstChar, lastChar));
                lastIsSpace = true;
            } else {
                lastIsSpace = false;
                lastChar = currentChar;
            }
        }

        for (int i = 0; i < words.size(); i++) {
            Word word1 = words.get(i);
            Word word2 = words.get((i + 1) % words.size());
            if (word1.lastChar != word2.firstChar) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isCircularSentence("leetcode exercises sound delightful"));
        System.out.println(solution.isCircularSentence("eetcode"));
        System.out.println(solution.isCircularSentence("Leetcode is cool"));
    }
}