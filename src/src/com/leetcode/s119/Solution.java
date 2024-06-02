package src.com.leetcode.s119;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        } else if (rowIndex == 1) {
            return List.of(1, 1);
        }
        int[] lastRow = new int[rowIndex + 1];
        lastRow[0] = 1;
        lastRow[1] = 1;
        for (int i = 2; i <= rowIndex; i++) {
            int[] currentRow = new int[i + 1];
            currentRow[0] = 1;
            for (int j = 1; j <= i - 1; j++) {
                currentRow[j] = lastRow[j - 1] + lastRow[j];
            }
            currentRow[i] = 1;
            lastRow = currentRow;
        }
        List<Integer> list = new ArrayList<>(lastRow.length);
        for (int i = 0; i < lastRow.length; i++) {
            list.add(lastRow[i]);
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