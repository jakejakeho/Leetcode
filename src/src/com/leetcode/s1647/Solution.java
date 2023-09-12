package src.com.leetcode.s1647;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected = 0 " + solution.minDeletions("aab"));
        System.out.println("Expected = 2 " + solution.minDeletions("aaabbbcc"));
        System.out.println("Expected = 2 " + solution.minDeletions("ceabaacb"));
    }

    public int minDeletions(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int j : charCount) {
            if (j != 0) {pq.offer(j);}
        }

        int numOfDelete = 0;
        while (pq.size() > 1) {
            int frequency = pq.poll();
            if (frequency > 0 && pq.peek() != null && frequency == pq.peek()) {
                int resultFrequency = Math.max(0, frequency - 1);
                numOfDelete += frequency - resultFrequency;
                pq.offer(resultFrequency);
            }
        }
        return numOfDelete;
    }
}