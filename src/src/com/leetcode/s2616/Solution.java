package src.com.leetcode.s2616;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2));
    }

    public int minimizeMax(int[] nums, int p) {
        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>(Comparator.comparing(Pair::getDifference));
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                pairPriorityQueue.offer(new Pair(nums[i], nums[j]));
            }
        }

        List<Pair> pairList = new ArrayList<>(p);
        while (p > 0) {
            pairList.add(pairPriorityQueue.poll());
            p--;
        }

        int result = 0;
        for (Pair pair : pairList) {
            result = Math.max(pair.getDifference(), result);
        }
        return result;
    }

    private static class Pair {
        int num1;
        int num2;
        int difference;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
            this.difference = Math.abs(num2 - num1);
        }

        int getDifference() {
            return difference;
        }
    }
}