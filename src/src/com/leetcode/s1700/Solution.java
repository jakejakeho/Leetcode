package src.com.leetcode.s1700;


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offer(student);
        }

        int sandwichIndex = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int student = queue.poll();
                if (student != sandwiches[sandwichIndex]) {
                    queue.offer(student);
                } else {
                    sandwichIndex++;
                }
            }
            if (queue.size() == size) {
                break;
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
    }
}