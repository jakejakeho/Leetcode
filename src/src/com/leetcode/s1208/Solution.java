package src.com.leetcode.s1208;

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLength = 0;
        int costSum = 0;
        int left = 0;
        int[] cost = new int[s.length()];
        for (int right = 0; right < s.length(); right++) {
            int currentCost = getCost(s.charAt(right), t.charAt(right));
            cost[right] = currentCost;
            while (costSum + currentCost > maxCost) {
                costSum -= cost[left];
                left++;
            }
            costSum += cost[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public int getCost(char s, char t) {
        return Math.abs(s - t);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.equalSubstring("abcd", "bcdf", 3));
        System.out.println(solution.equalSubstring("abcd", "cdef", 3));
        System.out.println(solution.equalSubstring("abcd", "acde", 0));
    }
}