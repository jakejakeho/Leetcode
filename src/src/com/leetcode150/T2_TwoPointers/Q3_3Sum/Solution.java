package src.com.leetcode150.T2_TwoPointers.Q3_3Sum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        result.add(List.of(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[] {0, 1, 1}));
        System.out.println(solution.threeSum(new int[] {0, 0, 0}));
        System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
    }
}