package src.com.leetcode.s3219;

import java.util.Arrays;

class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int i = 0;
        int j = 0;
        long rowCount = 1, colCount = 1, res = 0;
        while (i <= (m - 2) && j <= (n - 2)) {
            if (horizontalCut[i] > verticalCut[j]) {
                res += horizontalCut[i] * colCount;
                rowCount++;
                i++;
            } else {
                res += verticalCut[j] * rowCount;
                colCount++;
                j++;
            }
        }

        while (i <= (m - 2)) {
            res += horizontalCut[i] * colCount;
            rowCount++;
            i++;
        }

        while (j <= (n - 2)) {
            res += verticalCut[j] * rowCount;
            colCount++;
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        var vertical = new int[999];
        Arrays.fill(vertical, 1);
        var horizontal = new int[999];
        Arrays.fill(horizontal, 2);
        System.out.println(solution.minimumCost(1000, 1000, vertical, horizontal));
    }
}