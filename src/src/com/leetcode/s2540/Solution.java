package src.com.leetcode.s2540;

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int leftPointer = 0;
        int rightPointer = 0;
        while (leftPointer < nums1.length || rightPointer < nums2.length) {
            if (leftPointer + 1 < nums1.length && nums1[leftPointer] < nums2[rightPointer]) {
                leftPointer++;
            } else if (rightPointer + 1 < nums2.length && nums2[rightPointer] < nums1[leftPointer]) {
                rightPointer++;
            } else if (nums1[leftPointer] == nums2[rightPointer]){
                return nums1[leftPointer];
            } else {
                break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getCommon(new int[]{1, 2, 3}, new int[]{2, 4,}));
    }
}
