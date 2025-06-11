package src.com.leetcode.s3445;

class Solution {
    public int maxDifference(String s, int k) {
        int maxDiff = -1;
        for (int l = k; l <= s.length(); l++) {
            int[] count = new int[5];
            for (int i = 0; i < l; i++) {
                int key = s.charAt(i) - '0';
                count[key]++;
            }
            maxDiff = Math.max(maxDiff, maxDiff(count));
            for (int i = l; i < s.length(); i++) {
                count[s.charAt(i) - '0']++;
                count[s.charAt(i - l) - '0']--;
                maxDiff = Math.max(maxDiff, maxDiff(count));
            }
        }
        return maxDiff;
    }

    // max odd - min even
    private int maxDiff(int[] count) {
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (int c : count) {
            if (c % 2 == 1) {
                maxOdd = Math.max(maxOdd, c);
            } else {
                if (c != 0)
                    minEven = Math.min(minEven, c);
            }
        }
        if (maxOdd == Integer.MIN_VALUE || minEven == Integer.MAX_VALUE)
            return Integer.MIN_VALUE;
        return maxOdd - minEven;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxDifference("12233", 4));
//        System.out.println(solution.maxDifference("1122211", 3));
//        System.out.println(solution.maxDifference("110", 3));
        System.out.println(solution.maxDifference("330130303114333", 13));
    }
}