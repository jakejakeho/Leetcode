package src.com.leetcode.s823;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        //System.out.println(solution.numFactoredBinaryTrees(new int[] {2, 4}));
        System.out.println(solution.numFactoredBinaryTrees(new int[] {18, 3, 6, 2}));
        System.out.println(solution.numFactoredBinaryTrees(
            new int[] {45, 42, 2, 18, 23, 1170, 12, 41, 40, 9, 47, 24, 33, 28, 10, 32, 29, 17, 46, 11, 759, 37, 6, 26,
                21, 49, 31, 14, 19, 8, 13, 7, 27, 22, 3, 36, 34, 38, 39, 30, 43, 15, 4, 16, 35, 25, 20, 44, 5, 48}));
    }

    public int numFactoredBinaryTrees(int[] arr) {
        Set<Integer> set = new HashSet<>(arr.length);
        for (int num : arr) {
            set.add(num);
        }
        Map<Integer, Long> dp = new HashMap<>(arr.length);
        long totalNum = 0;
        for (int num : arr) {
            long recursiveResult = recursive(arr, set, dp, num);
            //System.out.println("num = " + num + " recursiveResult = " + recursiveResult);
            totalNum += recursiveResult;
        }
        return (int)(totalNum % (Math.pow(10, 9) + 7));
    }

    private long recursive(int[] arr, Set<Integer> set, Map<Integer, Long> dp, int currentParent) {
        if (dp.containsKey(currentParent)) {
            return dp.get(currentParent);
        }
        long result = 1;
        for (int divisor : arr) {
            if (divisor == currentParent) {continue;}
            int remainder = currentParent % divisor;
            if (remainder == 0) {
                int divided = currentParent / divisor;
                if (set.contains(divided)) {
                    long left = recursive(arr, set, dp, divided);
                    long right = recursive(arr, set, dp, divisor);
                    result += left * right;
                }
            }
        }
        dp.put(currentParent, result);
        return result;
    }
}