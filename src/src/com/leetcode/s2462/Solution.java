package src.com.leetcode.s2462;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
            solution.totalCost(new int[] {513, 633, 441, 583, 771, 616, 880, 713, 998, 209, 197, 923}, 10, 5));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        long totalCost = 0;
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>();
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
        if (costs.length <= 2 * candidates) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++)
                totalCost += costs[i];
            return totalCost;
        } else {
            for (int i = 0; i < candidates; i++) {
                leftQueue.offer(costs[i]);
                rightQueue.offer(costs[costs.length - 1 - i]);
            }
        }
        int left = candidates - 1;
        int right = costs.length - candidates;
        while(k > 0) {
            int leftSmallest = leftQueue.size() > 0 ? leftQueue.peek() : Integer.MAX_VALUE;
            int rightSmallest = rightQueue.size() > 0 ? rightQueue.peek() : Integer.MAX_VALUE;
            if (leftSmallest <= rightSmallest) {
                totalCost += leftQueue.poll();
                left++;
                if (left < right) {
                    leftQueue.offer(costs[left]);
                }
            } else {
                totalCost += rightQueue.poll();
                right--;
                if (left < right) {
                    rightQueue.offer(costs[right]);
                }
            }
            k--;
        }
        return totalCost;
    }
}