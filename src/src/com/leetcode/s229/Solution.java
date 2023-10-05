package src.com.leetcode.s229;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[] {3, 2, 3}));
        System.out.println(solution.majorityElement(new int[] {1}));
        System.out.println(solution.majorityElement(new int[] {1, 2}));
    }

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int times = n / 3;
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        int lastNum = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != lastNum) {
                lastNum = nums[i];
                count = 0;
            }
            count++;
            if (count > times) {
                result.add(nums[i]);
                while (i + 1 < nums.length && nums[i + 1] == lastNum) {
                    i++;
                }
            }
        }
        return result;
    }
}