package src.com.leetcode.s554;

import java.util.HashMap;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leastBricks(
            List.of(List.of(1, 2, 2, 1), List.of(3, 1, 2), List.of(1, 3, 2), List.of(2, 4), List.of(3, 1, 2),
                List.of(1, 3, 1, 1))));
        System.out.println(solution.leastBricks(
            List.of(List.of(1), List.of(1), List.of(1), List.of(1), List.of(1),
                List.of(1))));
        System.out.println(solution.leastBricks(
            List.of(List.of(1,1), List.of(2), List.of(1,1))));
        System.out.println(solution.leastBricks(
            List.of(List.of(100000000), List.of(100000000), List.of(100000000))));
    }

    public int leastBricks(List<List<Integer>> wall) {
        int height = wall.size();

        HashMap<Integer, Integer> numOfGaps = new HashMap<>();
        for (int i = 0; i < height; i++) {
            int currentGapIndex = -1;
            for (int j = 0; j < wall.get(i)
                                    .size() - 1; j++) {
                int brickSize = wall.get(i)
                                    .get(j);
                currentGapIndex += brickSize;
                numOfGaps.put(currentGapIndex, numOfGaps.getOrDefault(currentGapIndex, 0) + 1);
            }
        }

        int maxGaps = 0;
        for (Integer gap: numOfGaps.values()) {
            if (gap > maxGaps) {
                maxGaps = gap;
            }
        }
        return height - maxGaps;
    }
}