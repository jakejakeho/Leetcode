package src.com.leetcode.s1535;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getWinner(new int[]{1, 25, 35, 42, 68, 70}, 2));
    }

    public int getWinner(int[] arr, int k) {
        int arrMax = -1;
        for (int j : arr) {
            arrMax = Math.max(arrMax, j);
        }
        int lastWinner = arr[0];
        int round = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > lastWinner) {
                lastWinner = arr[i];
                round = 1;
            } else {
                round++;
            }
            if (round == k) {
                break;
            }
        }
        return lastWinner;
    }
}
