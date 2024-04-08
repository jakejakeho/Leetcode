package src.com.leetcode.s1700;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        Stack<Integer> sandwicheStack = new Stack<>();
        for (int student : students) {
            studentQueue.offer(student);
        }

        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwicheStack.push(sandwiches[i]);
        }

        int numOfTrial = 0;
        while (!studentQueue.isEmpty()) {
            int student = studentQueue.poll();
            if (sandwicheStack.peek() == student) {
                sandwicheStack.pop();
                numOfTrial = 0;
            } else {
                numOfTrial++;
                studentQueue.offer(student);
                if (numOfTrial == studentQueue.size()) {
                    break;
                }
            }
        }
        return numOfTrial;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
}