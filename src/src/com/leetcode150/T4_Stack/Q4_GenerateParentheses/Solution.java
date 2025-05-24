package src.com.leetcode150.T4_Stack.Q4_GenerateParentheses;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {
        if (n < 1) {return List.of();}
        List<String> result = new ArrayList<>();
        recursion(n, 0, result, new StringBuilder());
        return result;
    }

    private void recursion(int availableOpen, int availableClose, List<String> result, StringBuilder s) {
        if (availableOpen == 0 && availableClose == 0) {
            result.add(s.toString());
            return;
        }
        // '('
        if (availableOpen > 0) {
            s.append('(');
            recursion(availableOpen - 1, availableClose + 1, result, s);
            s.deleteCharAt(s.length() - 1);
        }
        // ')'
        if (availableClose > 0) {
            s.append(')');
            recursion(availableOpen, availableClose - 1, result, s);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(1));
    }
}