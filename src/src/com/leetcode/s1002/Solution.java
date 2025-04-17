package src.com.leetcode.s1002;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String word : words) {
            int[] newCount = new int[26];
            for (int i = 0; i < word.length(); i++) {
                newCount[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < count.length; i++) {
                count[i] = Math.min(count[i], newCount[i]);
            }
        }

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                result.add(String.valueOf((char)('a' + i)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.commonChars(new String[] {"bella", "label", "roller"}));
        System.out.println(solution.commonChars(new String[] {"cool", "lock", "cook"}));
        // []
        System.out.println(solution.commonChars(new String[] {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"}));
    }
}