package src.com.leetcode.s210;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(Arrays.toString(solution.findOrder(2, new int[][] {{1, 0}})));
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][] {{0, 1}, {1, 0}})));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> orders = new ArrayList<>();

        List<Integer>[] preNeeded = preNeeded(numCourses, prerequisites);
        boolean[] courseTakenArr = new boolean[numCourses];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < preNeeded.length; i++) {
            if (preNeeded[i].isEmpty()) {
                System.out.println("preNeeded[i] = size " + preNeeded[i].size());
                courseTakenArr[i] = true;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int courseTaken = queue.poll();

            orders.add(courseTaken);
            // remove this course in other pre needed
            for (int i = 0; i < preNeeded.length; i++) {
                preNeeded[i].remove(Integer.valueOf(courseTaken));
                if (preNeeded[i].isEmpty()) {
                    if (!courseTakenArr[i]) {
                        queue.offer(i);
                        courseTakenArr[i] = true;
                    }
                }
            }
        }
        if (orders.size() != numCourses) {
            return new int[]{};
        }
        return orders.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }

    public List<Integer>[] preNeeded(int numCourses, int[][] prerequisites) {
        List<Integer>[] preNeeded = new ArrayList[numCourses];

        for (int i = 0; i < preNeeded.length; i++) {
            preNeeded[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            System.out.println("course = " + course + " pre = " + pre);
            preNeeded[course].add(pre);
        }
        return preNeeded;
    }
}