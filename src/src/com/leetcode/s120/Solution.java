package src.com.leetcode.s120;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(2)));
        triangle.add(new ArrayList<>(List.of(3, 4)));
        triangle.add(new ArrayList<>(List.of(6, 5, 7)));
        triangle.add(new ArrayList<>(List.of(4, 1, 8, 3)));
        System.out.println(solution.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] minRow = new int[triangle.get(triangle.size() - 1).size()];
        int count = 0;
        for (int num : triangle.get(triangle.size() - 1)) {
            minRow[count++] = num;
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> loopRow = triangle.get(i);
            for (int j = 0; j < loopRow.size(); j++) {
                minRow[j] = loopRow.get(j) + Math.min(minRow[j], minRow[j + 1]);
            }
        }
        return minRow[0];
    }
}
