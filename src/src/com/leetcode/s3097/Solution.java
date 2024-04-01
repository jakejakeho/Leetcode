package src.com.leetcode.s3097;


class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int length = Integer.MAX_VALUE;
        int[] bits = new int[32];
        int left = 0;
        int right = 0;
        int current = 0;
        while (right < nums.length) {
            for (int i = 0; i < bits.length; i++) {
                if ((nums[right] & (1 << i)) > 0) {
                    bits[i]++;

                    if (bits[i] == 1) {
                        current |= (1 << i);
                    }
                }
            }

            while (left <= right && current >= k) {
                length = Math.min(length, right - left + 1);
                for (int i = 0; i < bits.length; i++) {
                    if ((nums[left] & (1 << i)) > 0) {
                        bits[i]--;

                        if (bits[i] == 0) {
                            current ^= (1 << i);
                        }
                    }
                }
                left++;
            }
            right++;
        }
        if (length == Integer.MAX_VALUE)
            return -1;
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        System.out.println(solution.minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 2}, 1));
        System.out.println(solution.minimumSubarrayLength(new int[]{1, 72, 32, 2, 95, 67}, 121));
    }
}