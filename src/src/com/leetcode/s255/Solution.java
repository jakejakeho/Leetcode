package src.com.leetcode.s255;


class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int[] index = new int[]{0};
        return dfs(preorder, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(int[] preorder, int[] index, int min, int max) {
        if (index[0] == preorder.length) {
            return true;
        }
        int root = preorder[index[0]];
        if (root <= min || root >= max) {
            return false;
        }

        index[0]++;
        boolean leftValid = dfs(preorder, index, min, root);
        boolean rightValid = dfs(preorder, index, root, max);
        return leftValid || rightValid;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.verifyPreorder(new int[]{5, 2, 1, 3, 6}));
        System.out.println(solution.verifyPreorder(new int[]{5, 2, 6, 1, 3}));
    }
}