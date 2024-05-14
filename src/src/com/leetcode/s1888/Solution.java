package src.com.leetcode.s1888;
class Solution {

    public int minFlips(String s) {
        boolean[] sArr = new boolean[s.length() * 2];
        for (int i = 0; i < s.length() * 2; i++) {
            if (s.charAt(i % s.length()) == '1') {
                sArr[i] = true;
            }
        }

        int minFlip = Integer.MAX_VALUE;
        int left = 0;
        int flip1 = 0; // 0 first
        int flip2 = 0; // 1 first
        boolean leftIsOdd = false;
        boolean rightIsOdd = false;
        for (int right = 0; right < 2 * sArr.length; right++) {
            if (!rightIsOdd && sArr[right] || rightIsOdd && !sArr[right]) {
                flip1++;
            }

            if (!rightIsOdd && !sArr[right] || rightIsOdd && sArr[right]) {
                flip2++;
            }
            rightIsOdd = !rightIsOdd;

            if ((right - left + 1) >= s.length()) {
                minFlip = Math.min(minFlip, Math.min(flip1, flip2));

                if (!leftIsOdd && sArr[left] || leftIsOdd && !sArr[left]) {
                    flip1--;
                }

                if (!leftIsOdd && !sArr[left] || leftIsOdd && sArr[left]) {
                    flip2--;
                }
                leftIsOdd = !leftIsOdd;
                left++;
            }
        }
        return minFlip;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFlips("111000"));
    }
}