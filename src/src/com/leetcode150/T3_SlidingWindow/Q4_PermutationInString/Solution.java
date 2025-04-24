package src.com.leetcode150.T3_SlidingWindow.Q4_PermutationInString;
class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] countMap = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            countMap[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        for (int right = 0; right < s1.length(); right++) {
            countMap[s2.charAt(right) - 'a']--;
        }

        if (isValid(countMap)) {
            return true;
        }

        for (int right = s1.length(); right < s2.length(); right++) {
            countMap[s2.charAt(right) - 'a']--;
            countMap[s2.charAt(left)- 'a']++;
            if (isValid(countMap)) {
                return true;
            }
            left++;
        }
        return false;
    }

    private boolean isValid(int[] countMap) {
        for (int i = 0; i < countMap.length; i++) {
            if (countMap[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }
}