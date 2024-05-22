package src.com.leetcode.s131;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        int index = 0;
        backtracking(s, result, currentList, index);
        return result;
    }

    private void backtracking(String s, List<List<String>> result, List<String> currentList, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                String substr = s.substring(index, i + 1);
                currentList.add(substr);
                backtracking(s, result, currentList, i + 1);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("aab"));
        System.out.println(solution.partition("a"));
    }
}