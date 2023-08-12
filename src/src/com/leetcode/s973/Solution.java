package src.com.leetcode.s973;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < points.length; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            priorityQueue.add(new int[]{i, distance});
        }

        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = points[priorityQueue.poll()[0]];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }
}
