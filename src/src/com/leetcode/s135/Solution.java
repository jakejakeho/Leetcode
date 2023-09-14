package src.com.leetcode.s135;
class Solution {

    public static final int EQUAL = 0;

    public static final int INCREASE = 1;

    public static final int DECREASE = 2;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expected = 5 result = " + solution.candy(new int[] {1, 0, 2}));
        System.out.println("Expected = 4 result = " + solution.candy(new int[] {1, 2, 2}));
        System.out.println("Expected = 4 result = " + solution.candy(new int[] {2, 3, 3}));
        System.out.println("Expected = 25 result = " + solution.candy(new int[] {1, 2, 3, 4, 5, 5, 6, 7, 8}));
        System.out.println("Expected = 25 result = " + solution.candy(new int[] {8, 7, 6, 5, 5, 4, 3, 2, 1}));
    }

    public int candy(int[] ratings) {
        if (ratings.length == 1) {return 1;}
        if (ratings.length == 0) {return 0;}
        int minCandy = 0;
        int increasOrDecreaseSize = 1;
        int lastDirection; //  0 = equal 1 increase 2 decrease
        if (ratings[0] == ratings[1]) {
            lastDirection = EQUAL;
        } else if (ratings[0] > ratings[1]) {
            lastDirection = DECREASE;
        } else {
            lastDirection = INCREASE;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] == ratings[i]) {
                if (lastDirection == INCREASE || lastDirection == DECREASE) {
                    minCandy += numOfCandy(increasOrDecreaseSize) - 1;
                }
                minCandy += 1;
                increasOrDecreaseSize = 1;
                lastDirection = EQUAL;
            } else if (ratings[i - 1] > ratings[i]) {
                if (lastDirection == INCREASE) {
                    minCandy += numOfCandy(increasOrDecreaseSize) - 1;
                    increasOrDecreaseSize = 1;
                }
                lastDirection = DECREASE;
                increasOrDecreaseSize++;
            } else {
                if (lastDirection == DECREASE) {
                    minCandy += numOfCandy(increasOrDecreaseSize) - 1;
                    increasOrDecreaseSize = 1;
                }
                lastDirection = INCREASE;
                increasOrDecreaseSize++;
            }
        }
        if (lastDirection == INCREASE || lastDirection == DECREASE) {
            minCandy += numOfCandy(increasOrDecreaseSize);
        }
        if (lastDirection == EQUAL) {
            minCandy += 1;
        }
        return minCandy;
    }

    public int numOfCandy(int size) {
        int candy = 0;
        for (int i = 1; i <= size; i++) {
            candy += i;
        }
        return candy;
    }
}