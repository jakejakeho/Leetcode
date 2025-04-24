package src.com.leetcode150.ArraysHashing.Q9LongestConsecutiveSequence;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int length = 1;
                int current = num;
                while (set.contains(current + 1)) {
                    length++;
                    current++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[] {2, 20, 4, 10, 3, 4, 5}));
        System.out.println(solution.longestConsecutive(new int[] {0, 3, 2, 5, 4, 6, 1, 1}));
    }
}
