package src.com.leetcode.s2438;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bestClosingTime("YYNY"));
    }

    public int bestClosingTime(String customers) {
        int penalty = 0;
        char[] customersArr = customers.toCharArray();
        for (int i = 0; i < customersArr.length; i++) {
            if (customersArr[i] == 'Y') {
                penalty++;
            }
        }
        int bestClosingTime = 0;
        int smallestPenalty = penalty;
        for (int i = 0; i < customersArr.length; i++) {
            if (customersArr[i]== 'Y') {
                penalty--;
            } else {
                penalty++;
            }
            if (penalty < smallestPenalty) {
                smallestPenalty = penalty;
                bestClosingTime = i + 1;
            }
        }
        return bestClosingTime;
    }
}