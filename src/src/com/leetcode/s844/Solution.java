package src.com.leetcode.s844;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int sSkip = 0;
        int tSkip = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sSkip++;
                    i--;
                } else if (sSkip > 0) {
                    sSkip--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tSkip++;
                    j--;
                } else if (tSkip > 0) {
                    tSkip--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            if (i >= 0 != j >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
        System.out.println(solution.backspaceCompare("ab##", "c#d#"));
        System.out.println(solution.backspaceCompare("a#c", "b"));
    }
}