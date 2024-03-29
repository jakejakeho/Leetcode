package src.com.leetcode.s1498;

class Solution {
    // O(n) sorting algorithm acutually it's O( max(n,(maxVal-minVal)) )
    private void countSort(int[] nums) {
        int max = 0;
        // count elements in array and get the boundries

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > max)
                max = nums[i];
        int[] freq = new int[max + 1];

        for (int i = 0; i < nums.length; i++)
            freq[nums[i]]++;

        int j = 0;
        // sort the array
        for (int i = 0; i <= max; i++) {
            while (freq[i]-- != 0) nums[j++] = i;
        }
    }

    public int numSubseq(int[] nums, int target) {
        final int MOD = 1000_000_007;
        countSort(nums);

        // Math.pow() returns double which will eventually overflow
        int[] pow = new int[nums.length + 1];
        pow[0] = 1;
        // 2^3 = 2^2 *2, 2^2 = 4 => 100b, "<< shift right" 100b<<1 = 1000b=8, slightly faster than multiplications
        for (int i = 1; i < pow.length; i++) pow[i] = (pow[i - 1] << 1) % MOD;

        int l = 0, r = nums.length - 1, res = 0;
        while (r >= l) {
            if (nums[l] + nums[r] > target) r--;
            else {
                res = (res + pow[r - l]) % MOD;
                l++;
            }
        }
        return res;
    }
}