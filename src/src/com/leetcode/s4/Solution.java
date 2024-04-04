package src.com.leetcode.s4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Pointer = 0;
        int num2Pointer = 0;
        int total = nums1.length + nums2.length;
        int mid;
        mid = total / 2;
        int median1 = -1;
        int median2 = -1;
        while ((num1Pointer + num2Pointer) <= mid) {
            if (num2Pointer >= nums2.length || (num1Pointer < nums1.length && nums1[num1Pointer] <= nums2[num2Pointer])) {
                median1 = median2;
                median2 = nums1[num1Pointer];
                num1Pointer++;
            } else if (num1Pointer >= nums1.length || nums1[num1Pointer] > nums2[num2Pointer]) {
                median1 = median2;
                median2 = nums2[num2Pointer];
                num2Pointer++;
            }
        }
        if (total % 2 == 0)
            return (median1 + median2) / 2.0;
        return median2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3,}, new int[]{2}));
//        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2,}, new int[]{3, 4}));
//        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3,}, new int[]{2, 7}));
    }
}