package src.com.leetcode.s202;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19));
    }

    public boolean isHappy(int n) {
        if (n == 1) {return true;}
        int current = n;
        Set<Integer> visited = new HashSet<>();
        while (current != 1) {
            int newNum = 0;
            String str = String.valueOf(current);
            for (int i = 0; i < str.length(); i++) {
                int digit = str.charAt(i) - '0';
                newNum += digit * digit;
            }
            if (visited.contains(newNum)) {
                return false;
            }
            if (newNum == 1) {
                return true;
            }
            visited.add(newNum);
            current = newNum;
        }
        return false;
    }
}