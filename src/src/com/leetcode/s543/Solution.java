package src.com.leetcode.s543;
import src.com.utils.TreeNode;

class Solution {

    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) {return 0;}
        int left = dfs(node.left);
        int right = dfs(node.right);

        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Case 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println(solution.diameterOfBinaryTree(root1));
    }
}
