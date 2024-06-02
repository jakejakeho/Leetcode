package src.com.leetcode.s119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] row = new int[rowIndex + 1];
        Arrays.fill(row, 1);

        for (int i = 2; i < rowIndex + 1; i++) {
            for (int j = 1; j < i; j++) {
                row[i - j] += row[i - j - 1];
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            list.add(row[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(3));
        System.out.println(solution.getRow(0));
        System.out.println(solution.getRow(1));
    }
}