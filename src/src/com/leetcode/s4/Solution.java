package src.com.leetcode.s4;
import java.util.Arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        int half = totalSize / 2;
        int[] a, b;
        if (nums1.length < nums2.length) {
            a = nums1;
            b = nums2;
        } else {
            a = nums2;
            b = nums1;
        }

        double result = 0;

        int left = 0;
        int right = a.length;
        while (true) {
            int i = (left + right) / 2;
            int j = half - i;

            int aLeft = (i > 0) ? a[i - 1] : Integer.MIN_VALUE;
            int aRight = (i < a.length) ? a[i] : Integer.MAX_VALUE;
            int bLeft = (j > 0) ? b[j - 1] : Integer.MIN_VALUE;
            int bRight = (j < b.length) ? b[j] : Integer.MAX_VALUE;
            if (aLeft <= bRight && bLeft <= aRight) {
                boolean isEven = (totalSize % 2) == 0;
                if (isEven) {
                    result = (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                } else {
                    result = Math.max(aLeft, bLeft);
                }
                break;
            } else if (aLeft > bRight){
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1, nums2;
        double output, expectedOutput;
        /**
         * Input: nums1 = [1,3], nums2 = [2]
         * Output: 2.00000
         * Explanation: merged array = [1,2,3] and median is 2.
         * **/
        nums1 = new int[]{1 ,3};
        nums2 = new int[]{2};
        output = solution.findMedianSortedArrays(nums1, nums2);
        expectedOutput = 2.00000;
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("output = " + output);
        System.out.println("expectedOutput = " + expectedOutput);
        System.out.println("correct = " + (output == expectedOutput));
    }
}
