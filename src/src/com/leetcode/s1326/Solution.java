package src.com.leetcode.s1326;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minTaps(5, new int[] {3, 4, 1, 1, 0, 0}));
        //System.out.println(solution.minTaps(3, new int[] {0, 0, 0, 0}));
    }

    public int minTaps(int n, int[] ranges) {
        List<int[]> coveredRange = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] > 0) {coveredRange.add(new int[] {i - ranges[i], i + ranges[i]});}
            //System.out.println(Arrays.toString(coveredRange.get(i)));
        }
        coveredRange.sort((a, b) -> {
            int aStart = Math.max(0, a[0]);
            int aEnd = Math.min(n + 1, a[1]);
            int bStart = Math.max(0, b[0]);
            int bEnd = Math.min(n + 1, b[1]);
            int aCovered = aEnd - aStart + 1;
            int bCovered = bEnd - bStart + 1;
            return bCovered - aCovered;
        });
        //System.out.println("---- sorted -----");
        boolean[] isCovered = new boolean[n + 1];
        int covered = 0;
        int numOfTap = 0;
        for (int[] range : coveredRange) {
            int start = range[0];
            int end = range[1];
            if (covered == (n + 1)) {break;}
            boolean isTapUsed = false;
            for (int i = 0; i < isCovered.length; i++) {
                if (!isCovered[i] && i >= start && i <= end) {
                    isCovered[i] = true;
                    covered++;
                    if (!isTapUsed) {
                        isTapUsed = true;
                    }
                }
                if (covered == (n + 1)) {
                    break;
                }
            }
            if (isTapUsed) {
                numOfTap++;
            }
        }
        return numOfTap == 0 ? -1 : numOfTap;
    }
}