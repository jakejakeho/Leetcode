package src.com.leetcode.s2483;

class Solution {
    public int bestClosingTime(String customers) {
        boolean[] hasCustomers = new boolean[customers.length()];
        int customerCount = 0;
        for (int i = 0; i < customers.length(); i++) {
            hasCustomers[i] = customers.charAt(i) == 'Y';
            if (hasCustomers[i]) {
                customerCount++;
            }
        }

        int minIndex = 0;
        int minPenalty = customerCount;
        int currentPenalty = customerCount;
        for (int i = 0; i < customers.length(); i++) {
            currentPenalty = currentPenalty + (hasCustomers[i] ? -1 : 1);
            if (currentPenalty < minPenalty) {
                minPenalty = currentPenalty;
                minIndex = i + 1;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bestClosingTime("YYNY"));
    }
}