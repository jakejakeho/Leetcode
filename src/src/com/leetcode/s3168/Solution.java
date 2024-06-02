package src.com.leetcode.s3168;

class Solution {
    public int minimumChairs(String s) {
        int chairNeeded = 0;
        int numOfChair = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                // need chair
                if (numOfChair == 0) {
                    chairNeeded++;
                    numOfChair++;
                }
                numOfChair--;
            } else {
                // free up chair
                numOfChair++;
            }
        }
        return chairNeeded;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumChairs("EEEEEEE"));
        System.out.println(solution.minimumChairs("ELELEEL"));
        System.out.println(solution.minimumChairs("ELEELEELLL"));
    }
}