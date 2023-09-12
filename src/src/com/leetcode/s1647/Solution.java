package src.com.leetcode.s1647;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected = 0 " + solution.minDeletions("aab"));
        System.out.println("Expected = 2 " + solution.minDeletions("aaabbbcc"));
        System.out.println("Expected = 2 " + solution.minDeletions("ceabaacb"));
    }

    public int minDeletions(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        int maxFrequency = 0;
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            maxFrequency = Math.max(entry.getValue(), maxFrequency);
        }
        List<Character>[] frequencies = new ArrayList[maxFrequency + 1];
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (frequencies[entry.getValue()] == null) {
                frequencies[entry.getValue()] = new ArrayList<>();
            }
            frequencies[entry.getValue()].add(entry.getKey());
        }

        int numOfDelete = 0;
        for (int currentFrequency = 0; currentFrequency < frequencies.length; currentFrequency++) {
            List<Character> sameFrequencyChars = frequencies[currentFrequency];
            if (sameFrequencyChars == null) {continue;}
            List<Character> toRemoves = new ArrayList<>();
            for (int i = 1; i < sameFrequencyChars.size(); i++) {
                int resultFrequency = currentFrequency;
                while (frequencies[resultFrequency] != null && resultFrequency - 1 >= 0) {
                    resultFrequency--;
                }
                numOfDelete += currentFrequency - resultFrequency;
                toRemoves.add(sameFrequencyChars.get(i));
                frequencies[resultFrequency] = new ArrayList<>();
                frequencies[resultFrequency].add(sameFrequencyChars.get(i));
            }
            for (Character c : toRemoves) {
                sameFrequencyChars.remove(c);
            }
        }
        return numOfDelete;
    }
}