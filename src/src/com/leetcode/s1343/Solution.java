package src.com.leetcode.s1343;


class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int result = 0;
        double average = (double) sum / k;
        if (average >= threshold) {
            result++;
        }
        for (int i = 0; i < arr.length - k; i++) {
            sum -= arr[i];
            sum += arr[i + k];
            average = (double) sum / k;
            if (average >= threshold) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
        System.out.println(solution.numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5));
    }
}