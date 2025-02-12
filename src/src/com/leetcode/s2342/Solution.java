package src.com.leetcode.s2342;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    public int maximumSum(int[] nums) {
        int maxSum = -1;
        // key digit sum, nums
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int digitSum = digitSum(num);
            map.computeIfAbsent(digitSum, (k) -> new PriorityQueue<>(Comparator.reverseOrder()))
               .add(num);
        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            if (entry.getValue()
                     .size() >= 2) {
                maxSum = Math.max(maxSum, sumOfBiggestTwo(entry.getValue()));
            }
        }
        return maxSum;
    }

    private int digitSum(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return digitSum;
    }

    private int sumOfBiggestTwo(PriorityQueue<Integer> queue) {
        int sum = 0;
        if (queue.size() >= 2) {
            for (int i = 0; i < 2; i++) {
                sum += queue.poll();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumSum(
            new int[] {229, 398, 269, 317, 420, 464, 491, 218, 439, 153, 482, 169, 411, 93, 147, 50, 347, 210, 251, 366,
                401}));
    }
}