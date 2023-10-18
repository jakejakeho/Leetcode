package src.com.leetcode.s1361;
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
            "true = " + solution.validateBinaryTreeNodes(4, new int[] {1, -1, 3, -1}, new int[] {2, -1, -1, -1}));
        //System.out.println(
        //    "True"+solution.validateBinaryTreeNodes(6, new int[] {1, -1, -1, 4, -1, -1}, new int[] {2, -1, -1, 5, -1,
        //    -1}));
        //System.out.println(
        //    "True = " + solution.validateBinaryTreeNodes(4, new int[] {3, -1, 1, -1}, new int[] {-1, -1, 0, -1}));
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n == 1) return true;
        int[] inDegrees = new int[n];
        for (int i = 0; i < leftChild.length; i++) {
            int left = leftChild[i];
            if (left == -1) {continue;}
            if (leftChild[left] == i || rightChild[left] == i) {
                return false;
            }
            if (inDegrees[i] >= 1 && inDegrees[left] == 0) {
                return false;
            }
            inDegrees[left]++;
        }

        for (int i = 0; i < rightChild.length; i++) {
            int right = rightChild[i];
            if (right == -1) {continue;}
            if (leftChild[right] == i || rightChild[right] == i) {
                return false;
            }
            if (inDegrees[i] >= 1 && inDegrees[right] == 0) {
                return false;
            }
            inDegrees[right]++;
        }

        int numOfTree = 0;
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] > 1) {
                return false;
            }
            if (inDegrees[i] == 0) {
                numOfTree++;
            }
        }

        return numOfTree == 1;
    }
}