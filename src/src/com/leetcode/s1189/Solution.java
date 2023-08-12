package src.com.leetcode.s1189;

import java.util.HashMap;

class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> balloonMap = getBalloonMap();
        char[] textCharArray = text.toCharArray();
        int numOfBalloons = 0;
        for (char c : textCharArray) {
            removeChar(balloonMap, c);
            if (isEmpty(balloonMap)) {
                numOfBalloons++;
                balloonMap = getBalloonMap();
            }
        }
        return numOfBalloons;
    }

    private HashMap<Character, Integer> getBalloonMap() {
        HashMap<Character, Integer> balloonMap = new HashMap<>();
        String balloon = "balloon";
        char[] balloonCharArray = balloon.toCharArray();
        for (char c : balloonCharArray) {
            balloonMap.put(c, balloonMap.getOrDefault(c, 0) + 1);
        }
        return balloonMap;
    }

    private void removeChar(HashMap<Character, Integer> balloonMap, char removeChar) {
        if (balloonMap.containsKey(removeChar)) {
            int count = balloonMap.get(removeChar);
            count--;
            if (count == 0) {
                balloonMap.remove(removeChar);
            } else {
                balloonMap.put(removeChar, count);
            }
        }
    }

    private boolean isEmpty(HashMap<Character, Integer> balloonMap) {
        return balloonMap.isEmpty();
    }
}