package src.com.leetcode.s210;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(Arrays.toString(solution.findOrder(2, new int[][] {{1, 0}})));
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][] {{0, 1}, {1, 0}})));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] pres = new ArrayList[numCourses];
        for (int i = 0; i < pres.length; i++) {
            pres[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int firstTake = pre[1];
            pres[course].add(firstTake);
        }

        boolean[] completed = new boolean[numCourses];
        Arrays.fill(completed, false);
        List<Integer> courseSequence = new ArrayList<>();
        recursive(pres, completed, courseSequence);

        int[] result = new int[numCourses];
        for (int i = 0; i < courseSequence.size(); i++) {
            result[i] = courseSequence.get(i);
        }
        return result;
    }

    public void recursive(List<Integer>[] prerequisites, boolean[] completed, List<Integer> courseSequence) {
        boolean hasCourseToTake = true;
        while (hasCourseToTake) {
            boolean reallyHasCourseToTake = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (completed[i]) {continue;}
                System.out.println(" i = " + i);
                List<Integer> pre = prerequisites[i];
                boolean preCompleted = true;
                for (int preCourse : pre) {
                    System.out.println("preCourse" + preCourse + !completed[preCourse]);
                    if (!completed[preCourse]) {
                        preCompleted = false;
                        break;
                    }
                }
                if (preCompleted) {
                    System.out.println("set i cmpleted = " + i);
                    completed[i] = true;
                    courseSequence.add(i);
                    reallyHasCourseToTake = true;
                    for (int j = 0; j < prerequisites.length; j++) {
                        List<Integer> preRemove = prerequisites[i];
                        preRemove.remove(Integer.valueOf(i));
                    }
                    break;
                }
            }
            hasCourseToTake = reallyHasCourseToTake;
        }
    }
}