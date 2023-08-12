package src.com.leetcode.s2024;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxConsecutiveAnswers("TTFF", 2) + "expected 4");
        System.out.println(solution.maxConsecutiveAnswers("TFFT", 1) + "expected 3");
        System.out.println(solution.maxConsecutiveAnswers("TTFTTFTT", 1) + "expected 5");
        System.out.println(solution.maxConsecutiveAnswers(
            "FTFFTFTFTTFTTFTTFFTTFFTTTTTFTTTFTFFTTFFFFFTTTTFTTTTTTTTTFTTFFTTFTFFTTTFFFFFTTTFFTTTTFTFTFFTTFTTTTTTF",
            32));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        if (k >= answerKey.length()) {return answerKey.length();}
        return slidingWindow(answerKey, k);
    }

    private int slidingWindow(String answerKey, int k) {
        int leftPointer = 0;
        int rightPointer = 0;
        int maxLength = 0;
        int tCounter = 0;
        int fCounter = 0;
        while (rightPointer < answerKey.length()) {
            if (answerKey.charAt(rightPointer) == 'T') {
                tCounter++;
            } else {
                fCounter++;
            }
            while (!(Math.min(tCounter, fCounter) <= k)) {
                if (answerKey.charAt(leftPointer) == 'T') {
                    tCounter--;
                } else {
                    fCounter--;
                }
                leftPointer++;
            }
            maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
            rightPointer++;
        }
        return maxLength;
    }
}