package src.com.leetcode.s75;
class Solution {

    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int n = 0;
        for (int i = 0; i < count.length; i++) {
            int c = count[i];
            for (int j = 0; j < c; j++) {
                nums[n++] = i;
            }
        }
    }
}