package src.com.leetcode.s1337;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.kWeakestRows(
            new int[][] {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1,}}, 3)));
        System.out.println(Arrays.toString(
            solution.kWeakestRows(new int[][] {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}}, 2)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
            Comparator.comparing((int[] a) -> a[0], Comparator.reverseOrder())
                      .thenComparing((int[] a) -> a[1], Comparator.reverseOrder()));
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int solider = 0;
            for (int person : row) {
                if (person == 1) {
                    solider++;
                }
            }
            priorityQueue.offer(new int[] {solider, i});
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            int[] pair = priorityQueue.poll();
            result[i] = pair[1];
        }
        return result;
    }
}