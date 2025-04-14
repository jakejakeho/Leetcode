package src.com.leetcode.s1534;
class Solution {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (i != j && j != k && i != k) {
                        if (Math.abs(arr[i] - arr[j]) <= a &&
                            Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k]) <= c) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countGoodTriplets(new int[] {3, 0, 1, 1, 9, 7}, 7, 2, 3));
        System.out.println(solution.countGoodTriplets(new int[] {1, 1, 2, 2, 3}, 0, 0, 1));
    }
}