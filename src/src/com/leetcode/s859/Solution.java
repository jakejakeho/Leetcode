package src.com.leetcode.s859;
import java.util.Arrays;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buddyStrings("aa", "aa") + " expected = true");
        System.out.println(solution.buddyStrings("ab", "ab") + " expected = false");

    }

    public boolean buddyStrings(String s, String goal) {
        int[] sHash = new int[26];
        int[] goalHash = new int[26];
        char[] sCharArr = s.toCharArray();
        char[] goalCHarArr = goal.toCharArray();
        int numOfUnique = 0;
        for (char c : sCharArr) {
            if (sHash[c - 'a'] == 0) {
                numOfUnique++;
            }
            sHash[c - 'a']++;
        }

        for (char c : goalCHarArr) {
            goalHash[c - 'a']++;
        }
        String sHashStr = Arrays.toString(sHash);
        String goalHashStr = Arrays.toString(goalHash);

        if (Objects.equals(sHashStr, goalHashStr)) {
            int numOfCharneedSwap = 0;
            for (int i = 0; i < sCharArr.length; i++) {
                char sChar = sCharArr[i];
                char goalChar = goalCHarArr[i];
                if (sChar != goalChar) {
                    numOfCharneedSwap++;
                    if (numOfCharneedSwap >= 3) {
                        return false;
                    }
                }
            }
            if (numOfCharneedSwap == 0)
                return s.length() / numOfUnique >= 2;
            return true;
        }
        return false;
    }
}