package src.com.leetcode.s682;

import java.util.Objects;
import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        for (String operation : operations) {
            if (Objects.equals(operation, "+")) {
                int score2 = scores.pop();
                int score1 = scores.pop();
                scores.push(score1);
                scores.push(score2);
                scores.push(score2 + score1);
            } else if (Objects.equals(operation, "D")) {
                int score1 = scores.pop();
                scores.push(score1);
                scores.push(score1 * 2);
            } else if (Objects.equals(operation, "C")) {
                scores.pop();
            } else {
                scores.push(Integer.valueOf(operation));
            }
        }

        int points = 0;
        while (!scores.isEmpty()) {
            points += scores.pop();
        }
        return points;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
}