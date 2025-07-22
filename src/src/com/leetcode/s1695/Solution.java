package src.com.leetcode.s1695;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    /**
     * 1695. Maximum Erasure Value Medium Topics premium lock icon Companies Hint You are given an array of positive
     * integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray
     * is equal to the sum of its elements.
     * <p>
     * Return the maximum score you can get by erasing exactly one subarray.
     * <p>
     * An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to
     * a[l],a[l+1],...,a[r] for some (l,r).
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [4,2,4,5,6] Output: 17 Explanation: The optimal subarray here is [2,4,5,6]. Example 2:
     * <p>
     * Input: nums = [5,2,1,2,5,2,1,2,5] Output: 8 Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 105 1 <= nums[i] <= 104
     *
     * @param nums
     * @return
     */
    public int maximumUniqueSubarray(int[] nums) {
        int max = 0;
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            while (set.contains(current)) {
                int eliminate = queue.poll();
                sum -= eliminate;
                set.remove(eliminate);
            }
            queue.offer(current);
            set.add(current);
            sum += current;
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumUniqueSubarray(new int[] {4, 2, 4, 5, 6}));
        System.out.println(solution.maximumUniqueSubarray(new int[] {5, 2, 1, 2, 5, 2, 1, 2, 5}));
    }
}