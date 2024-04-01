package src.com.leetcode.s3096;

class Solution {
    public int minimumLevels(int[] possible) {
        int danielPointer = 0;
        int bobPointer = 1;
        int numOfDanielPlay = 1;
        int danielPoints = possible[danielPointer] == 1 ? 1 : -1;
        int bobPoints = 0;
        for (int pointer = bobPointer; pointer < possible.length; pointer++) {
            bobPoints += possible[pointer] == 1 ? 1 : -1;
        }

        if (danielPoints > bobPoints) {
            return numOfDanielPlay;
        }

        while (bobPointer < possible.length) {
            if (danielPoints > bobPoints) {
                return numOfDanielPlay;
            }

            int point = possible[bobPointer] == 1 ? 1 : -1;
            danielPoints += point;
            bobPoints -= point;

            numOfDanielPlay++;
            danielPointer++;
            bobPointer++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumLevels(new int[]{1, 0, 1, 0}));
        System.out.println(solution.minimumLevels(new int[]{1, 1, 1, 1, 1}));
        System.out.println(solution.minimumLevels(new int[]{0, 0}));
    }
}