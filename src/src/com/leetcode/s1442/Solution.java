
class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int a = 0;
            for (int j = i + 1; j < arr.length; j++) {
                a ^= arr[j - 1];
                int b = 0;
                for (int k = j; k < arr.length; k++) {
                    b ^= arr[k];
                    if (a == b) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(solution.countTriplets(new int[]{1, 1, 1, 1,}));
    }
}