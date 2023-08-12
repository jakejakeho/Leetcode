package src.com.leetcode.s735;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.asteroidCollision(new int[] {-2, 2, -1, -2})));
    }

    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            int asteroid = asteroids[i];
            while (j > 0 && asteroids[j - 1] > 0 && asteroid < 0 && asteroids[j - 1] < Math.abs(asteroid)) {
                System.out.println("j = " + j);
                j--;
            }

            if (j == 0 || asteroid > 0 || asteroids[j -1] < 0) {
                asteroids[j++] = asteroid;
            } else if (asteroids[j - 1] == Math.abs(asteroid)){
                j--;
            }
        }
        int[] result = new int[j];
        System.arraycopy(asteroids, 0, result, 0, j);

        return result;
    }
}