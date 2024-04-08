package src.com.leetcode.s1700;


class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int numOfCircular = 0;
        int numOfSquare = 0;
        for (int student : students) {
            if (student == 0) {
                numOfCircular++;
            } else if (student == 1) {
                numOfSquare++;
            }
        }

        int j = 0;
        while (numOfCircular > 0 || numOfSquare > 0) {
            int sandwich = sandwiches[j];
            if (sandwich == 0 && numOfCircular > 0) {
                j++;
                numOfCircular--;
            } else if (sandwich == 1 && numOfSquare > 0) {
                j++;
                numOfSquare--;
            } else {
                break;
            }
        }
        return numOfCircular + numOfSquare;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
}