package src.com.leetcode.s786;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    record Data(int i1, int i2, double val) {}

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Data> priorityQueue = new PriorityQueue<>(
            Comparator.comparing(a -> a.val, Comparator.reverseOrder()));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                priorityQueue.offer(new Data(arr[i], arr[j], (double)arr[i] / arr[j]));
                if (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }
        }

        Data firstData = priorityQueue.peek();
        if (firstData == null)
            return null;

        return new int[] {firstData.i1, firstData.i2};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.kthSmallestPrimeFraction(new int[] {1, 2, 3, 5}, 3)));
    }
}