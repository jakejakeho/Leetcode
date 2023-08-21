package src.com.leetcode.s459;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("abcabc"));
    }

    public boolean repeatedSubstringPattern(String s) {
        for (int guestLengeth = 1; guestLengeth <= s.length() / 2; guestLengeth++) {
            boolean hasRemainder = s.length() % guestLengeth != 0;
            if (!hasRemainder) {
                int numOfStrCheck = s.length() / guestLengeth;

                boolean allValid = true;
                for (int checkIndex = 0; checkIndex < guestLengeth; checkIndex++) {
                    char lastChar = s.charAt(checkIndex);
                    boolean isValid = true;
                    for (int i = 1; i < numOfStrCheck; i++) {
                        if (s.charAt(i * guestLengeth + checkIndex) != lastChar) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) {
                        allValid = false;
                        break;
                    }
                }
                if (allValid) {
                    return true;
                }
            }
        }
        return false;
    }
}