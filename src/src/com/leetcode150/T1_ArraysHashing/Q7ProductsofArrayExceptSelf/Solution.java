package src.com.leetcode150.T1_ArraysHashing.Q7ProductsofArrayExceptSelf;
import java.util.Arrays;

class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] leftToRight = new int[nums.length + 1];
        int[] rightToLeft = new int[nums.length + 1];
        leftToRight[0] = 1;
        rightToLeft[rightToLeft.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            leftToRight[i + 1] = leftToRight[i] * nums[i];
        }
        for (int i = nums.length - 1; i >= 1; i--) {
            rightToLeft[i] = rightToLeft[i + 1] * nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftToRight[i] * rightToLeft[i + 1];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[] {1, 2, 4, 6})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[] {-1, 0, 1, 2, 3})));
    }
}  
