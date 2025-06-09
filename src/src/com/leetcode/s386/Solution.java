package src.com.leetcode.s386;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        recursion(result, n, 1);
        return result;
    }

    private void recursion(List<Integer> result, int n, int i) {
        if (i > n) {
            return;
        }
        int current = i >= 10 ? (i / 10 * 10) : 1;
        int target = current >= 10 ? current + 10 : current + 9;
        for (int j = current; j < target; j++) {
            if (j > n) {
                break;
            }
            result.add(j);
            recursion(result, n, j * 10);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lexicalOrder(13));
        System.out.println(solution.lexicalOrder(2));
    }
}