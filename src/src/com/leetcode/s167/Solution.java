package src.com.leetcode.s167;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
       int leftPointer = 0;
       int rightPointer = numbers.length - 1;
       while (leftPointer < rightPointer) {
           int sum = numbers[leftPointer] + numbers[rightPointer];
           if (sum > target) {
               rightPointer--;
           } else if (sum < target) {
               leftPointer++;
           } else {
               return new int[]{leftPointer, rightPointer};
           }
       }
       return null;
    }
}
