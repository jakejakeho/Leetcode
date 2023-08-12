package src.com.leetcode.s1189;

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] countMap = new int[26];
        char[] charArray = text.toCharArray();
        for (char c : charArray) {
            countMap[c - 'a']++;
        }

        String BALLOON = "balloon";
        int[] balloonMap = new int[26];
        char[] charArray2 = BALLOON.toCharArray();
        for (char c : charArray2) {
            balloonMap[c - 'a']++;
        }

        int maxNumber = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            int balloonCount = balloonMap[i];
            if (balloonCount == 0) continue;
            int textCount = countMap[i];
            int available = Math.floorDiv(textCount, balloonCount);
            if (available == 0)
                return 0;
            maxNumber = Math.min(maxNumber, available);
        }
        return maxNumber;
    }
}