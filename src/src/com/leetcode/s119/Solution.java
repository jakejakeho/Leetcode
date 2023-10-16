package src.com.leetcode.s119;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row0 = new ArrayList<>(1);
        row0.add(1);

        if (rowIndex == 0) {
            return row0;
        }

        List<Integer> row1 = new ArrayList<>(2);
        row1.add(1);
        row1.add(1);

        if (rowIndex == 1) {
            return row1;
        }

        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);
        result.add(1);
        for (int i = 2; i <= rowIndex; i++) {
            int first = result.get(0);
            int last;
            for (int j = 1; j < i; j++) {
                last = result.get(j);
                int tmp = first + last;
                first = last;
                result.set(j, tmp);
            }
            result.add(1);
        }
        return result;
    }
}