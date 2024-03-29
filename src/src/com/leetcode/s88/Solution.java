package src.com.leetcode.s88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int currentIndex = nums1.length - 1;
        int num1Index = m - 1;
        int num2Index = n - 1;
        while (currentIndex >= 0) {
            if (num2Index < 0 || (num1Index >= 0 && nums1[num1Index] > nums2[num2Index])) {
                nums1[currentIndex] = nums1[num1Index];
                num1Index--;
            } else if (num1Index < 0 || nums2[num2Index] >= nums1[num1Index]) {
                nums1[currentIndex] = nums2[num2Index];
                num2Index--;
            }
            currentIndex--;
        }
    }
}