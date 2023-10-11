package src.com.leetcode.s763;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String s) {
        int[] count = new int[26];
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            count[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        int currentCount = 0;
        Set<Character> characterHashSet = new HashSet<>();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            characterHashSet.add(c);
            count[c - 'a']--;
            if (count[c - 'a'] == 0) {
                characterHashSet.remove(c);
            }
            currentCount++;
            if (characterHashSet.isEmpty()) {
                result.add(currentCount);
                currentCount = 0;
            }
        }
        return result;
    }
}