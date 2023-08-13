package src.com.leetcode.s2369;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPartition(new int[]{4, 4, 4, 5, 6}));
    }

    public boolean validPartition(int[] nums) {
        int[] valid = new int[nums.length];
        Arrays.fill(valid, -1);
        return dfs(nums, 0, valid);
    }

    private boolean dfs(int[] nums, int index, int[] valid) {
        if (index >= valid.length) {
            return false;
        }
        if (valid[index] == -1) {
            boolean rule1Valid = index + 1 < nums.length && nums[index] == nums[index + 1];
//            System.out.println("rule1Valid = " + rule1Valid);

            boolean rule2Valid = index + 2 < nums.length && nums[index] == nums[index + 1] && nums[index] == nums[index + 2] && nums[index + 1] == nums[index + 2];
//            System.out.println("rule2Valid = " + rule2Valid);

            boolean rule3Valid = index + 2 < nums.length && (nums[index] == nums[index + 1] - 1) && (nums[index] == nums[index + 2] - 2);
//            System.out.println("rule3Valid = " + rule3Valid);

            boolean partition2 = false;
            if (rule1Valid) {
                if (index == nums.length - 2) {
                    partition2 = true;
                } else {
                    partition2 = dfs(nums, index + 2, valid);
                }
            }

            boolean partition3 = false;
            if (rule2Valid || rule3Valid) {
                if (index == nums.length - 3) {
                    partition3 = true;
                } else {
                    partition3 = dfs(nums, index + 3, valid);
                }
            }

//            System.out.println("partition2 = " + partition2 + " partition3 = " + partition3);

            boolean isValid = partition2 || partition3;
            valid[index] = isValid ? 1 : 0;
            return isValid;
        } else {
            return valid[index] == 1;
        }
    }
}
