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
        List<List<String>> res = new ArrayList<>();
        if (s.equals("")) {
            res.add(new ArrayList<String>());
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i + 1)) {
                for (List<String> list : partition(s.substring(i + 1))) {
                    list.add(0, s.substring(0, i + 1));
                    res.add(list);
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s, int n) {
        for (int i = 0; i < n / 2.0; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}