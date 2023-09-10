package src.com.leetcode.s1899;

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean matchFirst = false;
        boolean matchSecond = false;
        boolean matchThird = false;

        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[2] <= target[2] && triplet[1] <= target[1]) {
                if (triplet[0] == target[0]) {
                    matchFirst = true;
                }
                if (triplet[1] == target[1]) {
                    matchSecond = true;
                }

                if (triplet[2] == target[2]) {
                    matchThird = true;
                }
            }
            if (matchFirst && matchSecond && matchThird)
                return true;
        }
        return false;
    }
}