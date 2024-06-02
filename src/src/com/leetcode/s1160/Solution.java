package src.com.leetcode.s1160;

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] countMap = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            countMap[chars.charAt(i) - 'a']++;
        }

        int count = 0;
        for (String word : words) {
            if (isGood(word, countMap)) {
                count += word.length();
            }
        }
        return count;
    }

    private boolean isGood(String word, int[] countMap) {
        int[] currentCount = new int[26];
        boolean isGood = true;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            currentCount[index]++;
            if (currentCount[index] > countMap[index]) {
                isGood = false;
                i = Integer.MAX_VALUE - 1;
            }
        }
        return isGood;
    }
}