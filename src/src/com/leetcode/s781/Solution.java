package src.com.leetcode.s781;

class Solution {
    public int numRabbits(int[] answers) {
        int[] count = new int[1000];
        for (int i = 0; i < answers.length; i++) {
            count[answers[i]]++;
        }

        int total = 0;
        for (int i = 0; i < count.length; i++) {
            int groupFactor = i + 1;
            int v = count[i];
            total += (int) Math.ceil(v / (groupFactor + 0.0)) * groupFactor;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numRabbits(new int[]{1, 1, 2}));
        System.out.println(solution.numRabbits(new int[]{10, 10, 10}));
        System.out.println(solution.numRabbits(new int[]{1, 1, 1}));
    }
}