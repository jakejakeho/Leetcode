package src.com.leetcode.s2942;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char c  : word.toCharArray()) {
                if (c == x) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findWordsContaining(new String[] {"leet", "code"}, 'e'));
        System.out.println(solution.findWordsContaining(new String[] {"abc","bcd","aaaa","cbc"}, 'a'));
        System.out.println(solution.findWordsContaining(new String[] {"abc","bcd","aaaa","cbc"}, 'z'));
    }
}