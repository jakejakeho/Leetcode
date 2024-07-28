package src.com.leetcode.s3234;

class Solution {
    public int numberOfSubstrings(String s) {
        int totalCount = 0;
        int sum = 0;
        int[] prefixSum = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) == '1' ? 1 : 0;
            prefixSum[i] = sum;
        }

        for (int i = 0; i < s.length(); i++) {
            int ones = 0, zeros = 0;
            for (int j = i; j < s.length(); j++) {
                ones = prefixSum[j];
                if (i > 0) {
                    ones -= prefixSum[i - 1];
                }
                zeros = (j - i + 1) - ones;

                if (ones < (zeros * zeros)) {
                    j += (zeros * zeros) - ones - 1;
                } else {
                    totalCount++;
                    if (ones > zeros * zeros) {
                        int diff = (int) Math.sqrt(ones) - zeros;
                        int temp = diff + j;
                        if (temp >= s.length()) {
                            totalCount += s.length() - j - 1;
                        } else {
                            totalCount += temp - j;
                        }
                        j = temp;
                    }
                }
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubstrings("00011"));
        System.out.println(solution.numberOfSubstrings("101101"));
    }
}