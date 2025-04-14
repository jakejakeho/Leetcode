package src.com.leetcode.s1051;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int heightChecker(int[] heights) {
        int count = 0;
        // counting sort
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], map.getOrDefault(heights[i], 0) + 1);
        }
        int lastHeight = 1;
        for (int i = 0; i < heights.length; i++) {
            while (map.getOrDefault(lastHeight, 0) == 0) {
                lastHeight++;
            }
            int height = heights[i];
            if (lastHeight != height) {
                count++;
            }
            map.put(lastHeight, map.get(lastHeight) - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.heightChecker(new int[] {1, 1, 4, 2, 1, 3}));
        System.out.println(solution.heightChecker(new int[] {5, 1, 2, 3, 4}));
        System.out.println(solution.heightChecker(new int[] {1, 2, 3, 4, 5}));
    }
}