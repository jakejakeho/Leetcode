package src.com.leetcode.s131;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        String s = "aab";
        Solution solution = new Solution();
        //System.out.println(solution.partition(s));
        s = "bb";
        System.out.println(solution.partition(s));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        recursive(s, answer, 0, 1);
        return answer;
    }

    private void recursive(String s, List<List<String>> answer, int index, int numOfPart) {
        if (s.length() == 1) {
            answer.add(List.of(s));
            return;
        }
        if (numOfPart > s.length()) {
            return;
        }
        for (int i = index; i < s.length(); i++) {
            int midIndex = Math.min(s.length() - 1, index + numOfPart);
            String firstPart = s.substring(index, midIndex);
            boolean isFirstPartPalindrome = isPalindrome(firstPart);
            if (!isFirstPartPalindrome) continue;
            String secondPart = s.substring(midIndex, Math.min(midIndex + 1, s.length()));
            for (int j = 1; j <= secondPart.length(); j++) {
                recursive(s, answer, index + 1, j);
            }
        }
    }
    private boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        for (int i = 0; i < Math.round(s.length() / 2.0); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}