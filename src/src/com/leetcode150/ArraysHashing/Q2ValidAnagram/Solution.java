package src.com.leetcode150.ArraysHashing.Q2ValidAnagram;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (!countMap.containsKey(t.charAt(i))) {
                return false;
            }
            if (countMap.get(t.charAt(i)) == 1) {
                countMap.remove(t.charAt(i));
            } else {
                countMap.put(t.charAt(i), countMap.get(t.charAt(i)) - 1);
            }
        }
        return countMap.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution= new Solution();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
        System.out.println(solution.isAnagram("ab", "a"));
    }
}