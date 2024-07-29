package src.com.leetcode.s1395;

class Solution {
    public int numTeams(int[] rating) {
        int count = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] > rating[j] && rating[j] > rating[k]) {
                        count++;
                    } else if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        System.out.println("i = " + i + " j = " + j + " k = " + k);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTeams(new int[]{1, 2, 3, 4, 5, 6}));
    }
}