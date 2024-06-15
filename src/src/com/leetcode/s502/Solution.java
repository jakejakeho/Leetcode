package src.com.leetcode.s502;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    private static class Project implements Comparable<Project> {
        int profit;
        int capital;

        @Override
        public String toString() {
            return "Project{" +
                    "profit=" + profit +
                    ", capital=" + capital +
                    '}';
        }

        @Override
        public int compareTo(Project project) {
            return capital - project.capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Project> list = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            Project project = new Project();
            project.profit = profits[i];
            project.capital = capital[i];
            list.add(project);
        }

        int finalW = w;
        list.sort(Comparator.comparingInt(p -> p.getProfit(finalW)));
        while (!list.isEmpty() && k > 0) {
            Project project = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            if (project.capital > w) {
                break;
            } else {
                w += project.profit;
                int finalW2 = w;
                list.sort(Comparator.comparingInt(p -> p.getProfit(finalW2)));
            }
            k--;
        }
        return w;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        System.out.println(solution.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
    }
}