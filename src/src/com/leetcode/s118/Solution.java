package src.com.leetcode.s118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> lastRow = i >= 1 ? pascalTriangle.get(i - 1) : null;
            List<Integer> row = new ArrayList<>(i);
            row.add(1);
            for (int j = 1; j <= i - 1; j++) {
                row.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            if (i >= 1)
                row.add(1);
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }
}