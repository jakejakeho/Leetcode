package src.com.leetcode.s412;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean isDivisibleBy3 = i % 3 == 0;
            boolean isDivisibleBy5 = i % 5 == 0;
            if (isDivisibleBy3 && isDivisibleBy5) {
                result.add("FizzBuzz");
            } else if (isDivisibleBy3) {
                result.add("Fizz");
            } else if (isDivisibleBy5) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fizzBuzz(3));
        System.out.println(solution.fizzBuzz(5));
        System.out.println(solution.fizzBuzz(15));
    }
}