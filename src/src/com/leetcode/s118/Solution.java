package src.com.leetcode.s118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>(numRows);
        List<Integer> lastRow = null;
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 0; j < i - 1; j++) {
                row.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            if (i != 0) {
                row.add(1);
            }
            pascal.add(row);
            lastRow = row;
        }
        return pascal;
    }
}